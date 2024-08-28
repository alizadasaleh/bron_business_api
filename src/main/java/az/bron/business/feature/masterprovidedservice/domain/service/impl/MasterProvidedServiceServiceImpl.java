package az.bron.business.feature.masterprovidedservice.domain.service.impl;

import az.bron.business.feature.masterprovidedservice.domain.model.MasterProvidedService;
import az.bron.business.feature.masterprovidedservice.domain.repository.MasterProvidedServiceRepository;
import az.bron.business.feature.masterprovidedservice.domain.service.MasterProvidedServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MasterProvidedServiceServiceImpl implements MasterProvidedServiceService {
    private final MasterProvidedServiceRepository masterprovidedserviceRepository;

    @Override
    public MasterProvidedService create(MasterProvidedService masterprovidedservice) {
        return masterprovidedserviceRepository.save(masterprovidedservice);
    }

    @Override
    public MasterProvidedService update(MasterProvidedService masterprovidedservice) {
        return masterprovidedserviceRepository.save(masterprovidedservice);
    }

    @Override
    public Optional<MasterProvidedService> get(Long id) {
        return masterprovidedserviceRepository.findById(id);
    }

    @Override
    public List<MasterProvidedService> getAll() {
        return masterprovidedserviceRepository.findAll();
    }

    @Override
    public void delete(Long id) {
       masterprovidedserviceRepository.deleteById(id);
    }
}
