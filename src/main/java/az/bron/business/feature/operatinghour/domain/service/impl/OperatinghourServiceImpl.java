package az.bron.business.feature.operatinghour.domain.service.impl;

import az.bron.business.feature.operatinghour.domain.model.Operatinghour;
import az.bron.business.feature.operatinghour.domain.repository.OperatinghourRepository;
import az.bron.business.feature.operatinghour.domain.service.OperatinghourService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OperatinghourServiceImpl implements OperatinghourService {
    final OperatinghourRepository operatinghourRepository;

    @Override
    public void add(Operatinghour operatinghour) {
        operatinghourRepository.add(operatinghour);
    }

    @Override
    public void update(Operatinghour operatinghour) {
        operatinghourRepository.update(operatinghour);
    }

    @Override
    public void delete(Long id) {
        operatinghourRepository.delete(id);
    }

    @Override
    public Optional<Operatinghour> get(Long id) {
        return operatinghourRepository.get(id);
    }

    @Override
    public Collection<Operatinghour> getAll() {
        return operatinghourRepository.getAll();
    }
}

