package az.bron.business.feature.providedservice.application.facade.impl;

import az.bron.business.feature.providedservice.application.exception.ProvidedserviceNotFoundException;
import az.bron.business.feature.providedservice.application.facade.ProvidedserviceFacade;
import az.bron.business.feature.providedservice.application.mapper.ProvidedserviceMapper;
import az.bron.business.feature.providedservice.application.model.request.CreateProvidedserviceRequest;
import az.bron.business.feature.providedservice.application.model.request.UpdateProvidedserviceRequest;
import az.bron.business.feature.providedservice.application.model.response.CreateProvidedserviceResponse;
import az.bron.business.feature.providedservice.application.model.response.GetProvidedserviceResponse;
import az.bron.business.feature.providedservice.application.model.response.UpdateProvidedserviceResponse;
import az.bron.business.feature.providedservice.domain.model.Providedservice;
import az.bron.business.feature.providedservice.domain.service.ProvidedserviceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ProvidedserviceFacadeImpl implements ProvidedserviceFacade {
    private final ProvidedserviceService providedserviceService;

    private final ProvidedserviceMapper providedserviceMapper;

    @Override
    public CreateProvidedserviceResponse create(CreateProvidedserviceRequest request) {
        Providedservice providedservice = providedserviceMapper.toModel(request);
        providedserviceService.add(providedservice);

        return providedserviceMapper.toCreateResponse(providedservice);
    }

    @Override
    public UpdateProvidedserviceResponse update(Long id, UpdateProvidedserviceRequest request) {
        Providedservice providedservice = providedserviceMapper.toModel(request);

        var existingProvidedservice = providedserviceService.get(id);

        if (existingProvidedservice.isEmpty()) {
            throw new ProvidedserviceNotFoundException();
        }

        var providedserviceId = existingProvidedservice.get().getId();

        providedservice.setId(providedserviceId);

        providedserviceService.update(providedservice);

        return providedserviceMapper.toUpdateResponse(providedservice);
    }

    @Override
    public List<GetProvidedserviceResponse> getAll() {
        Collection<Providedservice> providedservices = providedserviceService.getAll();

        return providedservices.stream()
                .map(providedserviceMapper::toVehicleResponse)
                .toList();
    }

    @Override
    public GetProvidedserviceResponse get(Long id) {
        var providedservice = providedserviceService.get(id);

        if (providedservice.isEmpty()) {
            throw new ProvidedserviceNotFoundException();
        }

        return providedserviceMapper.toVehicleResponse(providedservice.get());
    }

    @Override
    public void delete(Long id) {
        providedserviceService.delete(id);
    }
}
