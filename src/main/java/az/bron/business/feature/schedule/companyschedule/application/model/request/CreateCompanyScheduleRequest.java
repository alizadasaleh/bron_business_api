package az.bron.business.feature.schedule.companyschedule.application.model.request;

import az.bron.business.feature.schedule.common.models.Schedule;
import lombok.Data;

@Data
public class CreateCompanyScheduleRequest {
    private Schedule schedule;
    private Long companyId;
}
