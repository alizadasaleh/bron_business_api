package az.bron.business.feature.operatinghour.application.exception;

import az.gov.dlp.exception.NotFoundException;
import az.gov.dlp.exception.model.ErrorDetails;

public class OperatinghourNotFoundException extends NotFoundException {
    public OperatinghourNotFoundException() {
        super(ErrorDetails.of("", "Operatinghour not found",
                "",
                ErrorDetails.error(314_00, "OperatinghourNotFound")));
    }
}
