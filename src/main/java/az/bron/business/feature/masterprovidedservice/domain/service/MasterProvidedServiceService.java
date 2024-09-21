package az.bron.business.feature.masterprovidedservice.domain.service;

import az.bron.business.feature.masterprovidedservice.domain.model.MasterProvidedService;

import java.util.List;
import java.util.Optional;

public interface MasterProvidedServiceService {
    MasterProvidedService create(MasterProvidedService masterprovidedservice);

    MasterProvidedService update(MasterProvidedService masterprovidedservice);

    Optional<MasterProvidedService> get(Long id);

    List<MasterProvidedService> getAll();

    void delete(Long id);

    void updateCoverImageUrl(String fileName, Long id);
}
