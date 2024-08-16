package az.bron.business.feature.businessowner.application.exception;

import az.gov.dlp.exception.NotFoundException;
import az.gov.dlp.exception.model.ErrorDetails;

public class BusinessownerNotFoundException extends NotFoundException {
    public BusinessownerNotFoundException() {
        super(ErrorDetails.of("", "Businessowner not found",
                "",
                ErrorDetails.error(314_00, "BusinessownerNotFound")));
    }
}
