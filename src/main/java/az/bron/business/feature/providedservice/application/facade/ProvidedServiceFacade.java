package az.bron.business.feature.providedservice.application.facade;

import az.bron.business.feature.providedservice.application.model.request.CreateProvidedServiceRequest;
import az.bron.business.feature.providedservice.application.model.request.UpdateProvidedServiceRequest;
import az.bron.business.feature.providedservice.application.model.response.CreateProvidedServiceResponse;
import az.bron.business.feature.providedservice.application.model.response.GetProvidedServiceResponse;
import az.bron.business.feature.providedservice.application.model.response.UpdateProvidedServiceResponse;

import java.util.List;

public interface ProvidedServiceFacade {
    CreateProvidedServiceResponse create(CreateProvidedServiceRequest request);

    UpdateProvidedServiceResponse update(Long id, UpdateProvidedServiceRequest request);

    GetProvidedServiceResponse get(Long id);

    List<GetProvidedServiceResponse> getAll();

    void delete(Long id);
}
