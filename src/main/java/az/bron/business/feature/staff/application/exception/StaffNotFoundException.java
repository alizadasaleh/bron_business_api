package az.bron.business.feature.staff.application.exception;

import az.gov.dlp.exception.NotFoundException;
import az.gov.dlp.exception.model.ErrorDetails;

public class StaffNotFoundException extends NotFoundException {
    public StaffNotFoundException() {
        super(ErrorDetails.of("", "Staff not found",
                "",
                ErrorDetails.error(314_00, "StaffNotFound")));
    }
}
