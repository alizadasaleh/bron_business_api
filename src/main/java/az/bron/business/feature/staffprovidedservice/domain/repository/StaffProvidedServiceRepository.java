package az.bron.business.feature.staffprovidedservice.domain.repository;

import az.bron.business.feature.staffprovidedservice.domain.model.StaffProvidedService;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffProvidedServiceRepository extends JpaRepository<StaffProvidedService, Long> {
    @Modifying
    @Query("UPDATE StaffProvidedService ms SET ms.coverImageUrl = :fileName WHERE ms.id = :id")
    void insertCoverImageUrl(String fileName, Long id);

    @Query("SELECT sps FROM StaffProvidedService sps WHERE sps.staff.id = :staffId AND sps.providedService.id = :providedServiceId")
    Optional<StaffProvidedService> getByStaff_IdAndProvidedService_Id(Long staffId, Long providedServiceId);
}
