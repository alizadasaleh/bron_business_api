package az.bron.business.feature.master.application.exception;

import az.gov.dlp.exception.NotFoundException;
import az.gov.dlp.exception.model.ErrorDetails;

public class MasterNotFoundException extends NotFoundException {
    public MasterNotFoundException() {
        super(ErrorDetails.of("", "Master not found",
                "",
                ErrorDetails.error(314_00, "MasterNotFound")));
    }
}
