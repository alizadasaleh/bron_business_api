package az.bron.business.feature.masterprovidedservice.domain.repository;

import az.bron.business.feature.masterprovidedservice.domain.model.MasterProvidedService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterProvidedServiceRepository extends JpaRepository<MasterProvidedService, Long> {
    @Modifying
    @Query("UPDATE MasterProvidedService ms SET ms.coverImageUrl = :fileName WHERE ms.id = :id")
    void insertCoverImageUrl(String fileName, Long id);
}
