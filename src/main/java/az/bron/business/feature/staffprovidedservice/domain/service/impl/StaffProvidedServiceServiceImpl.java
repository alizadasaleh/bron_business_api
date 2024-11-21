package az.bron.business.feature.staffprovidedservice.domain.service.impl;

import az.bron.business.feature.staffprovidedservice.domain.model.StaffProvidedService;
import az.bron.business.feature.staffprovidedservice.domain.repository.StaffProvidedServiceRepository;
import az.bron.business.feature.staffprovidedservice.domain.service.StaffProvidedServiceService;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StaffProvidedServiceServiceImpl implements StaffProvidedServiceService {
    private final StaffProvidedServiceRepository staffprovidedserviceRepository;

    @Override
    public StaffProvidedService create(StaffProvidedService staffprovidedservice) {
        return staffprovidedserviceRepository.save(staffprovidedservice);
    }

    @Override
    public StaffProvidedService update(StaffProvidedService staffprovidedservice) {
        return staffprovidedserviceRepository.save(staffprovidedservice);
    }

    @Override
    public Optional<StaffProvidedService> get(Long id) {
        return staffprovidedserviceRepository.findById(id);
    }

    @Override
    public List<StaffProvidedService> getAll() {
        return staffprovidedserviceRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        staffprovidedserviceRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateCoverImageUrl(String fileName, Long id) {
        staffprovidedserviceRepository.insertCoverImageUrl(fileName, id);

    }

    @Override
    public Optional<StaffProvidedService> getByStaffIdAndProvidedServiceId(Long staffId, Long staffId1) {
        return staffprovidedserviceRepository.getByStaff_IdAndProvidedService_Id(staffId, staffId1);
    }
}
