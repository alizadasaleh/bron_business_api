package az.bron.business.feature.providedservice.domain.repository;

import az.bron.business.feature.providedservice.domain.model.ProvidedService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvidedServiceRepository extends JpaRepository<ProvidedService, Long> {
}
