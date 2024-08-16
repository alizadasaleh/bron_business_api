package az.bron.business.feature.providedservice.domain.service.impl;

import az.bron.business.feature.providedservice.domain.model.Providedservice;
import az.bron.business.feature.providedservice.domain.repository.ProvidedserviceRepository;
import az.bron.business.feature.providedservice.domain.service.ProvidedserviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProvidedserviceServiceImpl implements ProvidedserviceService {
    final ProvidedserviceRepository providedserviceRepository;

    @Override
    public void add(Providedservice providedservice) {
        providedserviceRepository.add(providedservice);
    }

    @Override
    public void update(Providedservice providedservice) {
        providedserviceRepository.update(providedservice);
    }

    @Override
    public void delete(Long id) {
        providedserviceRepository.delete(id);
    }

    @Override
    public Optional<Providedservice> get(Long id) {
        return providedserviceRepository.get(id);
    }

    @Override
    public Collection<Providedservice> getAll() {
        return providedserviceRepository.getAll();
    }
}

