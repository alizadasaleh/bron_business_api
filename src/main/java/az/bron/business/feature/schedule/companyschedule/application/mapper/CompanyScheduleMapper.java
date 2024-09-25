package az.bron.business.feature.schedule.companyschedule.application.mapper;

import az.bron.business.feature.schedule.companyschedule.application.model.request.CreateCompanyScheduleRequest;
import az.bron.business.feature.schedule.companyschedule.application.model.request.UpdateCompanyScheduleRequest;
import az.bron.business.feature.schedule.companyschedule.application.model.response.CreateCompanyScheduleResponse;
import az.bron.business.feature.schedule.companyschedule.application.model.response.GetCompanyScheduleResponse;
import az.bron.business.feature.schedule.companyschedule.application.model.response.UpdateCompanyScheduleResponse;
import az.bron.business.feature.schedule.companyschedule.domain.model.CompanySchedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompanyScheduleMapper {
    @Mapping(source = "companyId", target = "company.id")
    CompanySchedule toModel(CreateCompanyScheduleRequest request);

    CompanySchedule toModel(UpdateCompanyScheduleRequest request);

    @Mapping(source = "company.id", target = "companyId")
    CreateCompanyScheduleResponse toCreateResponse(CompanySchedule companyschedule);

    @Mapping(source = "company.id", target = "companyId")
    UpdateCompanyScheduleResponse toUpdateResponse(CompanySchedule companyschedule);

    @Mapping(source = "company.id", target = "companyId")
    GetCompanyScheduleResponse toGetResponse(CompanySchedule companyschedule);
}
