package az.bron.business.feature.company.domain.model.contact;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalTime;
import lombok.Data;

@Data
public class WorkingHours {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime startTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime endTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime breakStartTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime breakEndTime;
}
