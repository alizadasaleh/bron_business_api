package az.bron.business.feature.appointment.application.model.request;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class CreateAppointmentRequest {
    private Long staffProvidedServiceId;
    private LocalDateTime startTime;

}
