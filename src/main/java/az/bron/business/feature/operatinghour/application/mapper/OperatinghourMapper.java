package az.bron.business.feature.operatinghour.application.mapper;

import az.bron.business.feature.operatinghour.application.model.request.CreateOperatinghourRequest;
import az.bron.business.feature.operatinghour.application.model.request.UpdateOperatinghourRequest;
import az.bron.business.feature.operatinghour.application.model.response.CreateOperatinghourResponse;
import az.bron.business.feature.operatinghour.application.model.response.GetOperatinghourResponse;
import az.bron.business.feature.operatinghour.application.model.response.UpdateOperatinghourResponse;
import az.bron.business.feature.operatinghour.domain.model.Operatinghour;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OperatinghourMapper {
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "modified", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    Operatinghour toModel(CreateOperatinghourRequest request);

    @Mapping(target = "created", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "modified", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    Operatinghour toModel(UpdateOperatinghourRequest request);

    CreateOperatinghourResponse toCreateResponse(Operatinghour operatinghour);

    UpdateOperatinghourResponse toUpdateResponse(Operatinghour operatinghour);

    GetOperatinghourResponse toVehicleResponse(Operatinghour operatinghour);
}