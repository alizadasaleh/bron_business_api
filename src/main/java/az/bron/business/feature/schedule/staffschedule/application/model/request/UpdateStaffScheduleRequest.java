package az.bron.business.feature.schedule.staffschedule.application.model.request;

import az.bron.business.feature.schedule.common.models.Schedule;
import lombok.Data;

@Data
public class UpdateStaffScheduleRequest {
    private Schedule schedule;

}
