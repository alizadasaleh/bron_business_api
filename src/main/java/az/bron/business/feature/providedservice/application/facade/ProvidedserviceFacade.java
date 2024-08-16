package az.bron.business.feature.providedservice.application.facade;

import az.bron.business.feature.providedservice.application.model.request.CreateProvidedserviceRequest;
import az.bron.business.feature.providedservice.application.model.request.UpdateProvidedserviceRequest;
import az.bron.business.feature.providedservice.application.model.response.CreateProvidedserviceResponse;
import az.bron.business.feature.providedservice.application.model.response.GetProvidedserviceResponse;
import az.bron.business.feature.providedservice.application.model.response.UpdateProvidedserviceResponse;

import java.util.List;

public interface ProvidedserviceFacade {
    CreateProvidedserviceResponse create(CreateProvidedserviceRequest dto);

    UpdateProvidedserviceResponse update(Long id, UpdateProvidedserviceRequest dto);

    List<GetProvidedserviceResponse> getAll();

    GetProvidedserviceResponse get(Long id);

    void delete(Long id);
}
