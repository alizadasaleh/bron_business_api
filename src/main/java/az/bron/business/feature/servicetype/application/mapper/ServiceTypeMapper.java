package az.bron.business.feature.servicetype.application.mapper;

import az.bron.business.feature.servicetype.application.model.request.CreateServiceTypeRequest;
import az.bron.business.feature.servicetype.application.model.request.UpdateServiceTypeRequest;
import az.bron.business.feature.servicetype.application.model.response.CreateServiceTypeResponse;
import az.bron.business.feature.servicetype.application.model.response.GetServiceTypeResponse;
import az.bron.business.feature.servicetype.application.model.response.UpdateServiceTypeResponse;
import az.bron.business.feature.servicetype.domain.model.ServiceType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ServiceTypeMapper {
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "modified", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    ServiceType toModel(CreateServiceTypeRequest request);

    @Mapping(target = "created", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "modified", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    ServiceType toModel(UpdateServiceTypeRequest request);

    CreateServiceTypeResponse toCreateResponse(ServiceType servicetype);

    UpdateServiceTypeResponse toUpdateResponse(ServiceType servicetype);

    GetServiceTypeResponse toVehicleResponse(ServiceType servicetype);
}