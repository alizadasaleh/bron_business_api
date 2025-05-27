package az.bron.business.feature.company.domain.repository;

import az.bron.business.common.application.model.request.SortDirection;
import az.bron.business.common.model.Location;
import az.bron.business.feature.company.application.model.request.CompanySearchFilter;
import az.bron.business.feature.company.application.model.request.SortCompanyBy;
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

    public SearchResult<CompanyWithDistance> searchCompanies(CompanySearchFilter searchFilter, int page, int size, SortDirection sortDir, SortCompanyBy sortCompanyBy) {
        Session session = entityManager.unwrap(Session.class);
        Location location = searchFilter.getLocation();
        String query = searchFilter.getQuery();

        return Search.session(session)
                .search(Company.class)
                .select(f -> f.composite()
                        .from(f.entity(),
                                f.distance("location", GeoPoint.of(location.getLatitude(), location.getLatitude())))
                        .as(CompanyWithDistance::new))
                .where(f -> {
                    var bool = f.bool();

                    if (query != null && !query.isBlank()) {
                        bool.must(f.match()
                                .fields("name", "description")
                                .matching(query));
                    }

                    if (searchFilter.getGender() != null) {
                        bool.must(f.match().fields("gender").matching(searchFilter.getGender()));
                    }

                    if (searchFilter.getRadius() != null) {
                        bool.must(f.spatial()
                                .within()
                                .field("location")
                                .circle(location.getLatitude(), location.getLongitude(), searchFilter.getRadius(), DistanceUnit.KILOMETERS));
                    }

                    return bool;
                })
                .sort(f -> {
                    var sort = f.composite();

                    if (sortCompanyBy != null) {
                        switch (sortCompanyBy) {
                            case DISTANCE -> {
                                if (sortDir == SortDirection.DESC) {
                                    sort.add(f.distance("location", location.getLatitude(), location.getLongitude()).desc());
                                } else {
                                    sort.add(f.distance("location", location.getLatitude(), location.getLongitude()).asc());
                                }
                            }
                            default -> {
                                if (sortDir == SortDirection.DESC) {
                                    sort.add(f.field("id").desc());
                                } else {
                                    sort.add(f.field("id").asc());
                                }
                            }
                        }
                    } else {
                        sort.add(f.distance("location", location.getLatitude(), location.getLongitude()).asc());
                    }

                    return sort;
                })
                .fetch(page, size);
    }
}
