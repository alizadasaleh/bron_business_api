package az.bron.business.feature.appointment.application.excpetion;

import az.gov.dlp.exception.NotFoundException;
import az.gov.dlp.exception.model.ErrorDetails;

public class AppointmentNotFound extends NotFoundException {
    public AppointmentNotFound(String message) {
        super(ErrorDetails.of("", "User not found",
                message,
                ErrorDetails.error(314_00, "UserNotFound")));
    }
}
