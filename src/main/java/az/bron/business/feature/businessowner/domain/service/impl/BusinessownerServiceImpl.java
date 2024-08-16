package az.bron.business.feature.businessowner.domain.service.impl;

import az.bron.business.feature.businessowner.domain.model.Businessowner;
import az.bron.business.feature.businessowner.domain.repository.BusinessownerRepository;
import az.bron.business.feature.businessowner.domain.service.BusinessownerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BusinessownerServiceImpl implements BusinessownerService {
    final BusinessownerRepository businessownerRepository;

    @Override
    public void add(Businessowner businessowner) {
        businessownerRepository.add(businessowner);
    }

    @Override
    public void update(Businessowner businessowner) {
        businessownerRepository.update(businessowner);
    }

    @Override
    public void delete(Long id) {
        businessownerRepository.delete(id);
    }

    @Override
    public Optional<Businessowner> get(Long id) {
        return businessownerRepository.get(id);
    }

    @Override
    public Collection<Businessowner> getAll() {
        return businessownerRepository.getAll();
    }
}

