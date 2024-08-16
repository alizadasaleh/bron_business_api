package az.bron.business.feature.providedservice.application.mapper;

import az.bron.business.feature.providedservice.application.model.request.CreateProvidedserviceRequest;
import az.bron.business.feature.providedservice.application.model.request.UpdateProvidedserviceRequest;
import az.bron.business.feature.providedservice.application.model.response.CreateProvidedserviceResponse;
import az.bron.business.feature.providedservice.application.model.response.GetProvidedserviceResponse;
import az.bron.business.feature.providedservice.application.model.response.UpdateProvidedserviceResponse;
import az.bron.business.feature.providedservice.domain.model.Providedservice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProvidedserviceMapper {
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "modified", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    Providedservice toModel(CreateProvidedserviceRequest request);

    @Mapping(target = "created", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "modified", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    Providedservice toModel(UpdateProvidedserviceRequest request);

    CreateProvidedserviceResponse toCreateResponse(Providedservice providedservice);

    UpdateProvidedserviceResponse toUpdateResponse(Providedservice providedservice);

    GetProvidedserviceResponse toVehicleResponse(Providedservice providedservice);
}