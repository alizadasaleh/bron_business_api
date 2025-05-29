package az.bron.business.feature.company.domain.repository;

import az.bron.business.common.application.model.request.SortDirection;
import az.bron.business.common.model.Location;
import az.bron.business.feature.company.application.model.request.CompanySearchFilter;
import az.bron.business.feature.company.application.model.request.SearchSortCompanyBy;
import az.bron.business.feature.company.domain.model.Company;
import az.bron.business.feature.company.domain.model.CompanyWithDistance;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.engine.spatial.DistanceUnit;
import org.hibernate.search.engine.spatial.GeoPoint;
import org.hibernate.search.mapper.orm.Search;
import org.springframework.stereotype.Repository;


@Repository
public class CompanySearchRepository {

    private final EntityManager entityManager;

    public CompanySearchRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public SearchResult<CompanyWithDistance> searchCompanies(CompanySearchFilter searchFilter,
                                                             int page,
                                                             int size,
                                                             SortDirection sortDir,
                                                             SearchSortCompanyBy searchSortCompanyBy) {
        Session session = entityManager.unwrap(Session.class);

        boolean hasLocation = searchFilter.getLatitude() != null && searchFilter.getLongitude() != null;

        return Search.session(session)
                .search(Company.class)
                .select(f -> {
                    if (hasLocation) {
                        GeoPoint geoPoint = GeoPoint.of(searchFilter.getLatitude(), searchFilter.getLongitude());
                        return f.composite()
                                .from(f.entity(), f.distance("location", geoPoint))
                                .as(CompanyWithDistance::new);
                    } else {
                        return f.composite()
                                .from(f.entity())
                                .as(entity -> new CompanyWithDistance(entity, null));
                    }
                })
                .where(f -> {
                    var bool = f.bool();

                    // Text search filter
                    String query = searchFilter.getQuery();
                    if (query != null && !query.isBlank()) {
                        bool.must(f.match()
                                .fields("name", "description")
                                .matching(query));
                    }

                    // Gender filter
                    if (searchFilter.getGender() != null) {
                        bool.must(f.match()
                                .field("gender")
                                .matching(searchFilter.getGender()));
                    }

                    // Location radius filter
                    if (hasLocation && searchFilter.getRadius() != null) {
                        bool.must(f.spatial()
                                .within()
                                .field("location")
                                .circle(searchFilter.getLatitude(),
                                        searchFilter.getLongitude(),
                                        searchFilter.getRadius(),
                                        DistanceUnit.KILOMETERS));
                    }

                    return bool;
                })
                .sort(f -> {
                    var sort = f.composite();

                    if (searchSortCompanyBy == SearchSortCompanyBy.DISTANCE && hasLocation) {
                        // Sort by distance
                        var distanceSort = f.distance("location", searchFilter.getLatitude(), searchFilter.getLongitude());
                        sort.add(sortDir == SortDirection.DESC ? distanceSort.desc() : distanceSort.asc());
                    }
                    return sort;
                })
                .fetch(page, size);
    }}
