package az.bron.business.feature.schedule.common.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalTime;
import lombok.Data;

@Data
public class BreakHours {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime breakStartTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime breakEndTime;
}
