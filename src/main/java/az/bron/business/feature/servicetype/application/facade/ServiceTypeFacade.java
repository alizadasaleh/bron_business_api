package az.bron.business.feature.servicetype.application.facade;

import az.bron.business.feature.servicetype.application.model.request.CreateServiceTypeRequest;
import az.bron.business.feature.servicetype.application.model.request.UpdateServiceTypeRequest;
import az.bron.business.feature.servicetype.application.model.response.CreateServiceTypeResponse;
import az.bron.business.feature.servicetype.application.model.response.GetServiceTypeResponse;
import az.bron.business.feature.servicetype.application.model.response.UpdateServiceTypeResponse;

import java.util.List;

public interface ServiceTypeFacade {
    CreateServiceTypeResponse create(CreateServiceTypeRequest dto);

    UpdateServiceTypeResponse update(Long id, UpdateServiceTypeRequest dto);

    List<GetServiceTypeResponse> getAll();

    GetServiceTypeResponse get(Long id);

    void delete(Long id);
}
