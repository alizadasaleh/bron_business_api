package az.bron.business.feature.providedservice.domain.service.impl;

import az.bron.business.feature.providedservice.domain.model.ProvidedService;
import az.bron.business.feature.providedservice.domain.repository.ProvidedServiceRepository;
import az.bron.business.feature.providedservice.domain.service.ProvidedServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProvidedServiceServiceImpl implements ProvidedServiceService {
    final ProvidedServiceRepository providedserviceRepository;

    @Override
    public void add(ProvidedService providedservice) {
        providedserviceRepository.add(providedservice);
    }

    @Override
    public void update(ProvidedService providedservice) {
        providedserviceRepository.update(providedservice);
    }

    @Override
    public void delete(Long id) {
        providedserviceRepository.delete(id);
    }

    @Override
    public Optional<ProvidedService> get(Long id) {
        return providedserviceRepository.get(id);
    }

    @Override
    public Collection<ProvidedService> getAll() {
        return providedserviceRepository.getAll();
    }
}

