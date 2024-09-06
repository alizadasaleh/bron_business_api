package az.bron.business.feature.masterprovidedservice.application.exception;

import az.gov.dlp.exception.NotFoundException;
import az.gov.dlp.exception.model.ErrorDetails;

public class MasterProvidedServiceNotFoundException extends NotFoundException {
    public MasterProvidedServiceNotFoundException() {
        super(ErrorDetails.of("", "MasterProvidedService not found",
                "",
                ErrorDetails.error(314_00, "MasterProvidedServiceNotFound")));
    }
}
