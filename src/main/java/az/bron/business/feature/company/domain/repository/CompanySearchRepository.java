package az.bron.business.feature.company.domain.repository;

import az.bron.business.common.model.Location;
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

    public SearchResult<CompanyWithDistance> searchCompanies(String keyword, Location location, int page, int size) {
        Session session = entityManager.unwrap(Session.class);

        return Search.session(session)
                .search(Company.class)
                .select(f -> f.composite()
                        .from(f.entity(),
                                f.distance("location", GeoPoint.of(location.getLatitude(),location.getLatitude())))
                        .as(CompanyWithDistance::new))
                .where(f -> f.bool()
                        .must(f.match()
                                .fields("name", "description")
                                .matching(keyword)
                            )
                        )
                .sort(f -> f.distance("location", location.getLatitude(), location.getLongitude()))
                .fetch(page, size);
    }
}
