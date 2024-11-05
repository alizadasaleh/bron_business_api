package az.bron.business.feature.providedservice.application.exception;

import az.gov.dlp.exception.NotFoundException;
import az.gov.dlp.exception.model.ErrorDetails;

public class ProvidedServiceNotFoundException extends NotFoundException {
    public ProvidedServiceNotFoundException() {
        super(ErrorDetails.of("", "ProvidedService not found",
                "",
                ErrorDetails.error(314_00, "ProvidedServiceNotFound")));
    }

    public ProvidedServiceNotFoundException(String message) {
        super(ErrorDetails.of("", "ProvidedService not found",
                message,
                ErrorDetails.error(314_00, "ProvidedServiceNotFound")));
    }
}
