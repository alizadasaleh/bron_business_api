package az.bron.business.feature.operatinghour.application.facade.impl;

import az.bron.business.feature.operatinghour.application.exception.OperatinghourNotFoundException;
import az.bron.business.feature.operatinghour.application.facade.OperatinghourFacade;
import az.bron.business.feature.operatinghour.application.mapper.OperatinghourMapper;
import az.bron.business.feature.operatinghour.application.model.request.CreateOperatinghourRequest;
import az.bron.business.feature.operatinghour.application.model.request.UpdateOperatinghourRequest;
import az.bron.business.feature.operatinghour.application.model.response.CreateOperatinghourResponse;
import az.bron.business.feature.operatinghour.application.model.response.GetOperatinghourResponse;
import az.bron.business.feature.operatinghour.application.model.response.UpdateOperatinghourResponse;
import az.bron.business.feature.operatinghour.domain.model.Operatinghour;
import az.bron.business.feature.operatinghour.domain.service.OperatinghourService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class OperatinghourFacadeImpl implements OperatinghourFacade {
    private final OperatinghourService operatinghourService;

    private final OperatinghourMapper operatinghourMapper;

    @Override
    public CreateOperatinghourResponse create(CreateOperatinghourRequest request) {
        Operatinghour operatinghour = operatinghourMapper.toModel(request);
        operatinghourService.add(operatinghour);

        return operatinghourMapper.toCreateResponse(operatinghour);
    }

    @Override
    public UpdateOperatinghourResponse update(Long id, UpdateOperatinghourRequest request) {
        Operatinghour operatinghour = operatinghourMapper.toModel(request);

        var existingOperatinghour = operatinghourService.get(id);

        if (existingOperatinghour.isEmpty()) {
            throw new OperatinghourNotFoundException();
        }

        var operatinghourId = existingOperatinghour.get().getId();

        operatinghour.setId(operatinghourId);

        operatinghourService.update(operatinghour);

        return operatinghourMapper.toUpdateResponse(operatinghour);
    }

    @Override
    public List<GetOperatinghourResponse> getAll() {
        Collection<Operatinghour> operatinghours = operatinghourService.getAll();

        return operatinghours.stream()
                .map(operatinghourMapper::toVehicleResponse)
                .toList();
    }

    @Override
    public GetOperatinghourResponse get(Long id) {
        var operatinghour = operatinghourService.get(id);

        if (operatinghour.isEmpty()) {
            throw new OperatinghourNotFoundException();
        }

        return operatinghourMapper.toVehicleResponse(operatinghour.get());
    }

    @Override
    public void delete(Long id) {
        operatinghourService.delete(id);
    }
}
