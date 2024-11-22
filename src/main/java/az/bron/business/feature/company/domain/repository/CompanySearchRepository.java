package az.bron.business.feature.company.domain.repository;

import az.bron.business.feature.company.domain.model.Company;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.search.mapper.orm.Search;
import org.springframework.stereotype.Repository;

@Repository
public class CompanySearchRepository {

    private final EntityManager entityManager;

    public CompanySearchRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Company> searchCompanies(String keyword) {
        Session session = entityManager.unwrap(Session.class);

        return Search.session(session)
                .search(Company.class)
                .where(f -> f.match()
                        .fields("name", "description")
                        .matching(keyword))
                .fetchHits(20);
    }
}
