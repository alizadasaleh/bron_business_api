package az.bron.business.feature.company.domain.repository;

import az.bron.business.feature.company.domain.model.Company;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("SELECT c FROM Company c " +
            "LEFT JOIN FETCH c.masters m " +
            "LEFT JOIN FETCH c.providedServices ps ")
    List<Company> getAllWithDetails();

    @Query("SELECT c FROM Company c " +
            "LEFT JOIN FETCH c.masters m " +
            "LEFT JOIN FETCH c.providedServices ps " +
            "where c.id = :companyId")
    Optional<Company> getWithDetails(Long companyId);

    @Modifying
    @Query("UPDATE Company c SET c.profileImageUrl = :fileName WHERE c.id = :id")
    void insertProfileImageUrl(String fileName, Long id);

    @Modifying
    @Query("UPDATE Company c SET c.logoImageUrl = :fileName WHERE c.id = :id")
    void insertLogoImageUrl(String fileName, Long id);

    @Modifying
    @Query("UPDATE Company c SET c.backgroundImageUrl = :fileName WHERE c.id = :id")
    void insertBackgroundImageUrl(String fileName, Long id);
}
