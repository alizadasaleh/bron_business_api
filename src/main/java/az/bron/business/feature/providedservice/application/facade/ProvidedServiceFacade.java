package az.bron.business.feature.providedservice.application.facade;

import az.bron.business.feature.providedservice.application.model.request.CreateProvidedServiceRequest;
import az.bron.business.feature.providedservice.application.model.request.UpdateProvidedServiceRequest;
import az.bron.business.feature.providedservice.application.model.response.CreateProvidedServiceResponse;
import az.bron.business.feature.providedservice.application.model.response.GetProvidedServiceResponse;
import az.bron.business.feature.providedservice.application.model.response.UpdateProvidedServiceResponse;

import java.util.List;

public interface ProvidedServiceFacade {
    CreateProvidedServiceResponse create(CreateProvidedServiceRequest dto);

    UpdateProvidedServiceResponse update(Long id, UpdateProvidedServiceRequest dto);

    List<GetProvidedServiceResponse> getAll();

    GetProvidedServiceResponse get(Long id);

    void delete(Long id);
}
