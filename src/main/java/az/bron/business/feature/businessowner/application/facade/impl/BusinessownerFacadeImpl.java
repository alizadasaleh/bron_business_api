package az.bron.business.feature.businessowner.application.facade.impl;

import az.bron.business.feature.businessowner.application.exception.BusinessownerNotFoundException;
import az.bron.business.feature.businessowner.application.facade.BusinessownerFacade;
import az.bron.business.feature.businessowner.application.mapper.BusinessownerMapper;
import az.bron.business.feature.businessowner.application.model.request.CreateBusinessownerRequest;
import az.bron.business.feature.businessowner.application.model.request.UpdateBusinessownerRequest;
import az.bron.business.feature.businessowner.application.model.response.CreateBusinessownerResponse;
import az.bron.business.feature.businessowner.application.model.response.GetBusinessownerResponse;
import az.bron.business.feature.businessowner.application.model.response.UpdateBusinessownerResponse;
import az.bron.business.feature.businessowner.domain.model.Businessowner;
import az.bron.business.feature.businessowner.domain.service.BusinessownerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class BusinessownerFacadeImpl implements BusinessownerFacade {
    private final BusinessownerService businessownerService;

    private final BusinessownerMapper businessownerMapper;

    @Override
    public CreateBusinessownerResponse create(CreateBusinessownerRequest request) {
        Businessowner businessowner = businessownerMapper.toModel(request);
        businessownerService.add(businessowner);

        return businessownerMapper.toCreateResponse(businessowner);
    }

    @Override
    public UpdateBusinessownerResponse update(Long id, UpdateBusinessownerRequest request) {
        Businessowner businessowner = businessownerMapper.toModel(request);

        var existingBusinessowner = businessownerService.get(id);

        if (existingBusinessowner.isEmpty()) {
            throw new BusinessownerNotFoundException();
        }

        var businessownerId = existingBusinessowner.get().getId();

        businessowner.setId(businessownerId);

        businessownerService.update(businessowner);

        return businessownerMapper.toUpdateResponse(businessowner);
    }

    @Override
    public List<GetBusinessownerResponse> getAll() {
        Collection<Businessowner> businessowners = businessownerService.getAll();

        return businessowners.stream()
                .map(businessownerMapper::toVehicleResponse)
                .toList();
    }

    @Override
    public GetBusinessownerResponse get(Long id) {
        var businessowner = businessownerService.get(id);

        if (businessowner.isEmpty()) {
            throw new BusinessownerNotFoundException();
        }

        return businessownerMapper.toVehicleResponse(businessowner.get());
    }

    @Override
    public void delete(Long id) {
        businessownerService.delete(id);
    }
}
