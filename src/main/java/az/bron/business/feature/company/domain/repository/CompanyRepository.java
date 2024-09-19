package az.bron.business.feature.company.domain.repository;

import az.bron.business.feature.company.domain.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("SELECT c FROM Company c " +
            "LEFT JOIN FETCH c.masters m " +
            "LEFT JOIN FETCH c.providedServices ps ")
    List<Company> getAllWithDetails();

    @Query("SELECT c FROM Company c " +
            "LEFT JOIN FETCH c.masters m " +
            "LEFT JOIN FETCH c.providedServices ps "+
            "where c.id = :companyId")
    Optional<Company> getWithDetails(Long companyId);
}
