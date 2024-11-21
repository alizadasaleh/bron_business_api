package az.bron.business.feature.appointment.application.excpetion;

import az.gov.dlp.exception.AlreadyExistsException;
import az.gov.dlp.exception.model.ErrorDetails;
import java.time.DayOfWeek;

public class AppointmentNotAvailableException extends AlreadyExistsException {
    public AppointmentNotAvailableException(DayOfWeek dayOfWeek) {
        super(ErrorDetails.of("", "Appointment is not available for this day",
                "Appointment for" + dayOfWeek.toString() + " is not available",
                ErrorDetails.error(314_00, "StaffNotFound")));
    }
    public AppointmentNotAvailableException(String message) {
        super(ErrorDetails.of("", "Appointment is not available for this day",
                message,
                ErrorDetails.error(314_00, "StaffNotFound")));
    }


}
