package az.bron.business.feature.operatinghour.application.facade;

import az.bron.business.feature.operatinghour.application.model.request.CreateOperatinghourRequest;
import az.bron.business.feature.operatinghour.application.model.request.UpdateOperatinghourRequest;
import az.bron.business.feature.operatinghour.application.model.response.CreateOperatinghourResponse;
import az.bron.business.feature.operatinghour.application.model.response.GetOperatinghourResponse;
import az.bron.business.feature.operatinghour.application.model.response.UpdateOperatinghourResponse;

import java.util.List;

public interface OperatinghourFacade {
    CreateOperatinghourResponse create(CreateOperatinghourRequest dto);

    UpdateOperatinghourResponse update(Long id, UpdateOperatinghourRequest dto);

    List<GetOperatinghourResponse> getAll();

    GetOperatinghourResponse get(Long id);

    void delete(Long id);
}
