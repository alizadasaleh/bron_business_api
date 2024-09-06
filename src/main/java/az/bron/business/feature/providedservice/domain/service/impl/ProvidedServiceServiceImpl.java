package az.bron.business.feature.providedservice.domain.service.impl;

import az.bron.business.feature.providedservice.domain.model.ProvidedService;
import az.bron.business.feature.providedservice.domain.repository.ProvidedServiceRepository;
import az.bron.business.feature.providedservice.domain.service.ProvidedServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProvidedServiceServiceImpl implements ProvidedServiceService {
    private final ProvidedServiceRepository providedserviceRepository;

    @Override
    public ProvidedService create(ProvidedService providedservice) {
        return providedserviceRepository.save(providedservice);
    }

    @Override
    public ProvidedService update(ProvidedService providedservice) {
        return providedserviceRepository.save(providedservice);
    }

    @Override
    public Optional<ProvidedService> get(Long id) {
        return providedserviceRepository.findById(id);
    }

    @Override
    public List<ProvidedService> getAll() {
        return providedserviceRepository.findAll();
    }

    @Override
    public List<ProvidedService> getAllByCompanyId(Long companyId) {
        return providedserviceRepository.findAllByCompanyId(companyId);
    }

    @Override
    public void delete(Long id) {
       providedserviceRepository.deleteById(id);
    }
}
