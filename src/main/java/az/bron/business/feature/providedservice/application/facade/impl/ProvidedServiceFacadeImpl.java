package az.bron.business.feature.providedservice.application.facade.impl;

import az.bron.business.feature.providedservice.application.exception.ProvidedServiceNotFoundException;
import az.bron.business.feature.providedservice.application.facade.ProvidedServiceFacade;
import az.bron.business.feature.providedservice.application.mapper.ProvidedServiceMapper;
import az.bron.business.feature.providedservice.application.model.request.CreateProvidedServiceRequest;
import az.bron.business.feature.providedservice.application.model.request.UpdateProvidedServiceRequest;
import az.bron.business.feature.providedservice.application.model.response.CreateProvidedServiceResponse;
import az.bron.business.feature.providedservice.application.model.response.GetProvidedServiceResponse;
import az.bron.business.feature.providedservice.application.model.response.UpdateProvidedServiceResponse;
import az.bron.business.feature.providedservice.domain.model.ProvidedService;
import az.bron.business.feature.providedservice.domain.service.ProvidedServiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ProvidedServiceFacadeImpl implements ProvidedServiceFacade {
    private final ProvidedServiceService providedserviceService;

    private final ProvidedServiceMapper providedserviceMapper;

    @Override
    public CreateProvidedServiceResponse create(CreateProvidedServiceRequest request) {
        ProvidedService providedservice = providedserviceMapper.toModel(request);
        providedserviceService.add(providedservice);

        return providedserviceMapper.toCreateResponse(providedservice);
    }

    @Override
    public UpdateProvidedServiceResponse update(Long id, UpdateProvidedServiceRequest request) {
        ProvidedService providedservice = providedserviceMapper.toModel(request);

        var existingProvidedService = providedserviceService.get(id);

        if (existingProvidedService.isEmpty()) {
            throw new ProvidedServiceNotFoundException();
        }

        var providedserviceId = existingProvidedService.get().getId();

        providedservice.setId(providedserviceId);

        providedserviceService.update(providedservice);

        return providedserviceMapper.toUpdateResponse(providedservice);
    }

    @Override
    public List<GetProvidedServiceResponse> getAll() {
        Collection<ProvidedService> providedServices = providedserviceService.getAll();

        return providedServices.stream()
                .map(providedserviceMapper::toVehicleResponse)
                .toList();
    }

    @Override
    public GetProvidedServiceResponse get(Long id) {
        var providedservice = providedserviceService.get(id);

        if (providedservice.isEmpty()) {
            throw new ProvidedServiceNotFoundException();
        }

        return providedserviceMapper.toVehicleResponse(providedservice.get());
    }

    @Override
    public void delete(Long id) {
        providedserviceService.delete(id);
    }
}
