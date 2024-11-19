package az.bron.business.feature.providedservice.domain.service;

import az.bron.business.feature.providedservice.domain.model.ProvidedService;
import az.bron.business.feature.providedservice.domain.specification.ProvidedServiceFilter;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProvidedServiceService {
    ProvidedService create(ProvidedService providedservice);

    ProvidedService update(ProvidedService providedservice);

    Optional<ProvidedService> get(Long id);

    Page<ProvidedService> getAll(Pageable pageable, ProvidedServiceFilter filter);

    List<ProvidedService> getAllByCompanyId(Long companyId);

    void delete(Long id);

    void updateCoverImageUrl(String fileName, Long id);
}
