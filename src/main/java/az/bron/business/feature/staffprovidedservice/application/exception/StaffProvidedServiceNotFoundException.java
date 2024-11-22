package az.bron.business.feature.staffprovidedservice.application.exception;

import az.gov.dlp.exception.NotFoundException;
import az.gov.dlp.exception.model.ErrorDetails;

public class StaffProvidedServiceNotFoundException extends NotFoundException {
    public StaffProvidedServiceNotFoundException(String message) {
        super(ErrorDetails.of("", "StaffProvidedService not found",
                message,
                ErrorDetails.error(314_00, "StaffProvidedServiceNotFound")));
    }

    public StaffProvidedServiceNotFoundException() {
        super(ErrorDetails.of("", "StaffProvidedService not found",
                "",
                ErrorDetails.error(314_00, "StaffProvidedServiceNotFound")));
    }
}
