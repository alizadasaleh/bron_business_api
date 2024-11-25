package az.bron.business.feature.slots.application.model;

import java.time.LocalTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Slot {
    LocalTime startTime;

}
