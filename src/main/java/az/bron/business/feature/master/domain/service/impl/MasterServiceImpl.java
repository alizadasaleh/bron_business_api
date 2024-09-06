package az.bron.business.feature.master.domain.service.impl;

import az.bron.business.feature.master.domain.model.Master;
import az.bron.business.feature.master.domain.repository.MasterRepository;
import az.bron.business.feature.master.domain.service.MasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MasterServiceImpl implements MasterService {
    private final MasterRepository masterRepository;

    @Override
    public Master create(Master master) {
        return masterRepository.save(master);
    }

    @Override
    public Master update(Master master) {
        return masterRepository.save(master);
    }

    @Override
    public Optional<Master> get(Long id) {
        return masterRepository.findById(id);
    }

    @Override
    public List<Master> getAll() {
        return masterRepository.findAll();
    }

    @Override
    public List<Master> getAllByCompanyId(Long companyId) {
        return masterRepository.findAllByCompanyId(companyId);
    }

    @Override
    public void delete(Long id) {
       masterRepository.deleteById(id);
    }
}
