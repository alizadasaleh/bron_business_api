package az.bron.business.feature.staff.application.mapper;

import az.bron.business.feature.providedservice.application.mapper.ProvidedServiceMapper;
import az.bron.business.feature.staff.application.model.request.CreateStaffRequest;
import az.bron.business.feature.staff.application.model.request.UpdateStaffRequest;
import az.bron.business.feature.staff.application.model.response.CreateStaffResponse;
import az.bron.business.feature.staff.application.model.response.GetStaffResponse;
import az.bron.business.feature.staff.application.model.response.UpdateStaffResponse;
import az.bron.business.feature.staff.domain.model.Staff;
import az.bron.business.feature.staffprovidedservice.application.mapper.StaffProvidedServiceMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {StaffProvidedServiceMapper.class, ProvidedServiceMapper.class})
public interface StaffMapper {
    @Mapping(source = "companyId", target = "company.id")
    Staff toModel(CreateStaffRequest request);

    @Mapping(source = "companyId", target = "company.id")
    Staff toModel(UpdateStaffRequest request);

    @Mapping(target = "companyId", source = "company.id")
    CreateStaffResponse toCreateResponse(Staff staff);

    @Mapping(target = "companyId", source = "company.id")
    UpdateStaffResponse toUpdateResponse(Staff staff);

    GetStaffResponse toGetResponse(Staff staff);

}
