package az.bron.business.feature.contact.domain.model;

import lombok.Data;

import java.time.LocalTime;

@Data
public class WorkingHours {
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalTime breakStartTime;
    private LocalTime breakEndTime;
}
