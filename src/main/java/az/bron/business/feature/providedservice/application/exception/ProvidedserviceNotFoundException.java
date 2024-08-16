package az.bron.business.feature.providedservice.application.exception;

import az.gov.dlp.exception.NotFoundException;
import az.gov.dlp.exception.model.ErrorDetails;

public class ProvidedserviceNotFoundException extends NotFoundException {
    public ProvidedserviceNotFoundException() {
        super(ErrorDetails.of("", "Providedservice not found",
                "",
                ErrorDetails.error(314_00, "ProvidedserviceNotFound")));
    }
}
