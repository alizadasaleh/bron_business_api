package az.bron.business.feature.staffprovidedservice.application.mapper;

import az.bron.business.feature.staffprovidedservice.application.model.request.CreateStaffProvidedServiceRequest;
import az.bron.business.feature.staffprovidedservice.application.model.request.UpdateStaffProvidedServiceRequest;
import az.bron.business.feature.staffprovidedservice.application.model.response.CreateStaffProvidedServiceResponse;
import az.bron.business.feature.staffprovidedservice.application.model.response.GetCertainProvidedServiceResponse;
import az.bron.business.feature.staffprovidedservice.application.model.response.GetStaffProvidedServiceResponse;
import az.bron.business.feature.staffprovidedservice.application.model.response.UpdateStaffProvidedServiceResponse;
import az.bron.business.feature.staffprovidedservice.domain.model.StaffProvidedService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StaffProvidedServiceMapper {
    @Mapping(source = "staffId", target = "staff.id")
    @Mapping(source = "serviceId", target = "providedService.id")
    StaffProvidedService toModel(CreateStaffProvidedServiceRequest request);

    @Mapping(source = "staffId", target = "staff.id")
    @Mapping(source = "serviceId", target = "providedService.id")
    StaffProvidedService toModel(UpdateStaffProvidedServiceRequest request);

    @Mapping(target = "staffId", source = "staff.id")
    @Mapping(target = "serviceId", source = "providedService.id")
    CreateStaffProvidedServiceResponse toCreateResponse(StaffProvidedService staffprovidedservice);

    @Mapping(target = "staffId", source = "staff.id")
    @Mapping(target = "serviceId", source = "providedService.id")
    UpdateStaffProvidedServiceResponse toUpdateResponse(StaffProvidedService staffprovidedservice);

    @Mapping(target = "staffId", source = "staff.id")
    @Mapping(target = "serviceId", source = "providedService.id")
    GetStaffProvidedServiceResponse toGetResponse(StaffProvidedService staffprovidedservice);

    @Mapping(target = "id", source = "providedService.id")
    @Mapping(target = "name", source = "providedService.name")
    @Mapping(target = "description", source = "providedService.description")
    @Mapping(target = "duration", source = "providedService.duration")
    @Mapping(target = "companyId", source = "providedService.company.id")
    GetCertainProvidedServiceResponse toGetCertainResponse(StaffProvidedService staffprovidedservice);
}
