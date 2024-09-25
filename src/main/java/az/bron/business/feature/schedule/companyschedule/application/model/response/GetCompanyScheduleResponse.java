package az.bron.business.feature.schedule.companyschedule.application.model.response;

import az.bron.business.feature.schedule.companyschedule.domain.model.Schedule;
import lombok.Data;

@Data
public class GetCompanyScheduleResponse {
    private Long id;
    private Schedule schedule;
    private Long companyId;
}
