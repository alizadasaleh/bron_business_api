package az.bron.business.feature.providedservice.application.mapper;

import az.bron.business.feature.providedservice.application.model.request.CreateProvidedServiceRequest;
import az.bron.business.feature.providedservice.application.model.request.UpdateProvidedServiceRequest;
import az.bron.business.feature.providedservice.application.model.response.CreateProvidedServiceResponse;
import az.bron.business.feature.providedservice.application.model.response.GetProvidedServiceResponse;
import az.bron.business.feature.providedservice.application.model.response.UpdateProvidedServiceResponse;
import az.bron.business.feature.providedservice.domain.model.ProvidedService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProvidedServiceMapper {
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "modified", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    ProvidedService toModel(CreateProvidedServiceRequest request);

    @Mapping(target = "created", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "modified", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    ProvidedService toModel(UpdateProvidedServiceRequest request);

    CreateProvidedServiceResponse toCreateResponse(ProvidedService providedservice);

    UpdateProvidedServiceResponse toUpdateResponse(ProvidedService providedservice);

    GetProvidedServiceResponse toVehicleResponse(ProvidedService providedservice);
}