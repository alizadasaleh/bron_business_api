package az.bron.business.feature.schedule.companyschedule.application.model.request;

import az.bron.business.feature.schedule.companyschedule.domain.model.Schedule;
import lombok.Data;

@Data
public class UpdateCompanyScheduleRequest {
    private Schedule schedule;
}
