package az.bron.business.feature.schedule.staffschedule.application.facade;

import az.bron.business.feature.schedule.staffschedule.application.model.request.CreateStaffScheduleRequest;
import az.bron.business.feature.schedule.staffschedule.application.model.request.UpdateStaffScheduleRequest;
import az.bron.business.feature.schedule.staffschedule.application.model.response.CreateStaffScheduleResponse;
import az.bron.business.feature.schedule.staffschedule.application.model.response.GetStaffScheduleResponse;
import az.bron.business.feature.schedule.staffschedule.application.model.response.UpdateStaffScheduleResponse;
import java.util.List;

public interface StaffScheduleFacade {
    CreateStaffScheduleResponse create(CreateStaffScheduleRequest request);

    UpdateStaffScheduleResponse update(Long id, UpdateStaffScheduleRequest request);

    GetStaffScheduleResponse get(Long id);

    List<GetStaffScheduleResponse> getAll();

    void delete(Long id);
}
