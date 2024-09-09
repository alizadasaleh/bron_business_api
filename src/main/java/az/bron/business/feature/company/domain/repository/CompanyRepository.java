package az.bron.business.feature.company.domain.repository;

import az.bron.business.feature.company.domain.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("SELECT c FROM Company c " +
            "LEFT JOIN FETCH c.masters m " +
            "LEFT JOIN FETCH c.providedServices ps ")
    List<Company> getAllWithDetails();
}
