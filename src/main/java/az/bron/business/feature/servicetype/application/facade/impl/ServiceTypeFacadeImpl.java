package az.bron.business.feature.servicetype.application.facade.impl;

import az.bron.business.feature.servicetype.application.exception.ServiceTypeNotFoundException;
import az.bron.business.feature.servicetype.application.facade.ServiceTypeFacade;
import az.bron.business.feature.servicetype.application.mapper.ServiceTypeMapper;
import az.bron.business.feature.servicetype.application.model.request.CreateServiceTypeRequest;
import az.bron.business.feature.servicetype.application.model.request.UpdateServiceTypeRequest;
import az.bron.business.feature.servicetype.application.model.response.CreateServiceTypeResponse;
import az.bron.business.feature.servicetype.application.model.response.GetServiceTypeResponse;
import az.bron.business.feature.servicetype.application.model.response.UpdateServiceTypeResponse;
import az.bron.business.feature.servicetype.domain.model.ServiceType;
import az.bron.business.feature.servicetype.domain.service.ServiceTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ServiceTypeFacadeImpl implements ServiceTypeFacade {
    private final ServiceTypeService servicetypeService;

    private final ServiceTypeMapper servicetypeMapper;

    @Override
    public CreateServiceTypeResponse create(CreateServiceTypeRequest request) {
        ServiceType servicetype = servicetypeMapper.toModel(request);
        servicetypeService.add(servicetype);

        return servicetypeMapper.toCreateResponse(servicetype);
    }

    @Override
    public UpdateServiceTypeResponse update(Long id, UpdateServiceTypeRequest request) {
        ServiceType servicetype = servicetypeMapper.toModel(request);

        var existingServiceType = servicetypeService.get(id);

        if (existingServiceType.isEmpty()) {
            throw new ServiceTypeNotFoundException();
        }

        var servicetypeId = existingServiceType.get().getId();

        servicetype.setId(servicetypeId);

        servicetypeService.update(servicetype);

        return servicetypeMapper.toUpdateResponse(servicetype);
    }

    @Override
    public List<GetServiceTypeResponse> getAll() {
        Collection<ServiceType> servicetypes = servicetypeService.getAll();

        return servicetypes.stream()
                .map(servicetypeMapper::toVehicleResponse)
                .toList();
    }

    @Override
    public GetServiceTypeResponse get(Long id) {
        var servicetype = servicetypeService.get(id);

        if (servicetype.isEmpty()) {
            throw new ServiceTypeNotFoundException();
        }

        return servicetypeMapper.toVehicleResponse(servicetype.get());
    }

    @Override
    public void delete(Long id) {
        servicetypeService.delete(id);
    }
}
