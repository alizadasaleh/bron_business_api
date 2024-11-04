package az.bron.business.feature.staffprovidedservice.domain.service;

import az.bron.business.feature.staffprovidedservice.domain.model.StaffProvidedService;
import java.util.List;
import java.util.Optional;

public interface StaffProvidedServiceService {
    StaffProvidedService create(StaffProvidedService staffprovidedservice);

    StaffProvidedService update(StaffProvidedService staffprovidedservice);

    Optional<StaffProvidedService> get(Long id);

    List<StaffProvidedService> getAll();

    void delete(Long id);

    void updateCoverImageUrl(String fileName, Long id);
}
