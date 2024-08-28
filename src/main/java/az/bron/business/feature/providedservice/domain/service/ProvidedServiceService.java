package az.bron.business.feature.providedservice.domain.service;

import az.bron.business.feature.providedservice.domain.model.ProvidedService;

import java.util.List;
import java.util.Optional;

public interface ProvidedServiceService {
    ProvidedService create(ProvidedService providedservice);

    ProvidedService update(ProvidedService providedservice);

    Optional<ProvidedService> get(Long id);

    List<ProvidedService> getAll();

    void delete(Long id);
}
