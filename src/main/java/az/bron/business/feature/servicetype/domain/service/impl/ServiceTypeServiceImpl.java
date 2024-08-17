package az.bron.business.feature.servicetype.domain.service.impl;

import az.bron.business.feature.servicetype.domain.model.ServiceType;
import az.bron.business.feature.servicetype.domain.repository.ServiceTypeRepository;
import az.bron.business.feature.servicetype.domain.service.ServiceTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceTypeServiceImpl implements ServiceTypeService {
    final ServiceTypeRepository servicetypeRepository;

    @Override
    public void add(ServiceType servicetype) {
        servicetypeRepository.add(servicetype);
    }

    @Override
    public void update(ServiceType servicetype) {
        servicetypeRepository.update(servicetype);
    }

    @Override
    public void delete(Long id) {
        servicetypeRepository.delete(id);
    }

    @Override
    public Optional<ServiceType> get(Long id) {
        return servicetypeRepository.get(id);
    }

    @Override
    public Collection<ServiceType> getAll() {
        return servicetypeRepository.getAll();
    }
}

