package az.bron.business.feature.schedule.staffschedule.application.mapper;

import az.bron.business.feature.schedule.staffschedule.application.model.request.CreateStaffScheduleRequest;
import az.bron.business.feature.schedule.staffschedule.application.model.request.UpdateStaffScheduleRequest;
import az.bron.business.feature.schedule.staffschedule.application.model.response.CreateStaffScheduleResponse;
import az.bron.business.feature.schedule.staffschedule.application.model.response.GetStaffScheduleResponse;
import az.bron.business.feature.schedule.staffschedule.application.model.response.UpdateStaffScheduleResponse;
import az.bron.business.feature.schedule.staffschedule.domain.model.StaffSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StaffScheduleMapper {

    @Mapping(source = "staffId", target = "staff.id")
    StaffSchedule toModel(CreateStaffScheduleRequest request);

    StaffSchedule toModel(UpdateStaffScheduleRequest request);

    @Mapping(source = "staff.id", target = "staffId")
    CreateStaffScheduleResponse toCreateResponse(StaffSchedule staffschedule);

    @Mapping(source = "staff.id", target = "staffId")
    UpdateStaffScheduleResponse toUpdateResponse(StaffSchedule staffschedule);

    @Mapping(source = "staff.id", target = "staffId")
    GetStaffScheduleResponse toGetResponse(StaffSchedule staffschedule);
}
