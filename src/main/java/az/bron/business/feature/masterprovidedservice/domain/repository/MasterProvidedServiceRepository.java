package az.bron.business.feature.masterprovidedservice.domain.repository;

import az.bron.business.feature.masterprovidedservice.domain.model.MasterProvidedService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterProvidedServiceRepository extends JpaRepository<MasterProvidedService, Long> {
}
