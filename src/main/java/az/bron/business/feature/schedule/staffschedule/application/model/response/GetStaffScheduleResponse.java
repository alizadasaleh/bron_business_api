package az.bron.business.feature.schedule.staffschedule.application.model.response;

import az.bron.business.feature.schedule.common.models.Schedule;
import lombok.Data;

@Data
public class GetStaffScheduleResponse {
    private Long id;
    private Schedule schedule;
    private Long staffId;}
