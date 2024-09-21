package az.bron.business.feature.providedservice.domain.repository;

import az.bron.business.feature.providedservice.domain.model.ProvidedService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Repository
public interface ProvidedServiceRepository extends JpaRepository<ProvidedService, Long> {
    List<ProvidedService> findAllByCompanyId(Long companyId);

    @Modifying
    @Query("UPDATE ProvidedService s SET s.coverImageUrl = :fileName WHERE s.id = :id")
    void insertCoverImageUrl(String fileName, Long id);
}
