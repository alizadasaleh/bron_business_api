package az.bron.business.feature.contact.domain.model;

import lombok.Data;

import java.util.Map;

@Data
public class Schedule {
    private Map<Workday,WorkingHours> schedule;
}
