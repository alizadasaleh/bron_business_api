package az.bron.business.feature.businessowner.application.mapper;

import az.bron.business.feature.businessowner.application.model.request.CreateBusinessownerRequest;
import az.bron.business.feature.businessowner.application.model.request.UpdateBusinessownerRequest;
import az.bron.business.feature.businessowner.application.model.response.CreateBusinessownerResponse;
import az.bron.business.feature.businessowner.application.model.response.GetBusinessownerResponse;
import az.bron.business.feature.businessowner.application.model.response.UpdateBusinessownerResponse;
import az.bron.business.feature.businessowner.domain.model.Businessowner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BusinessownerMapper {
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "modified", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    Businessowner toModel(CreateBusinessownerRequest request);

    @Mapping(target = "created", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "modified", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    Businessowner toModel(UpdateBusinessownerRequest request);

    CreateBusinessownerResponse toCreateResponse(Businessowner businessowner);

    UpdateBusinessownerResponse toUpdateResponse(Businessowner businessowner);

    GetBusinessownerResponse toVehicleResponse(Businessowner businessowner);
}