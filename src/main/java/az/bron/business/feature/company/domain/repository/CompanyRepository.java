package az.bron.business.feature.company.domain.repository;

import az.bron.business.feature.company.domain.model.Company;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("SELECT c FROM Company c " +
            "LEFT JOIN FETCH c.staffs m " +
            "LEFT JOIN FETCH c.providedServices ps ")
    Page<Company> getAllWithDetails(Pageable pageable);

    Page<Company> findAll(Specification<Company> spec, Pageable pageable);

    @Query("SELECT c FROM Company c " +
            "LEFT JOIN FETCH c.staffs m " +
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
