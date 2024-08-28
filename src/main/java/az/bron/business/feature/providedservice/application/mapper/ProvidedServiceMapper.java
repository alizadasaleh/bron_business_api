package az.bron.business.feature.providedservice.application.mapper;

import az.bron.business.feature.providedservice.application.model.request.CreateProvidedServiceRequest;
import az.bron.business.feature.providedservice.application.model.request.UpdateProvidedServiceRequest;
import az.bron.business.feature.providedservice.application.model.response.CreateProvidedServiceResponse;
import az.bron.business.feature.providedservice.application.model.response.GetProvidedServiceResponse;
import az.bron.business.feature.providedservice.application.model.response.UpdateProvidedServiceResponse;
import az.bron.business.feature.providedservice.domain.model.ProvidedService;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProvidedServiceMapper {
    ProvidedService toModel(CreateProvidedServiceRequest request);

    ProvidedService toModel(UpdateProvidedServiceRequest request);

    CreateProvidedServiceResponse toCreateResponse(ProvidedService providedservice);

    UpdateProvidedServiceResponse toUpdateResponse(ProvidedService providedservice);

    GetProvidedServiceResponse toGetResponse(ProvidedService providedservice);
}
