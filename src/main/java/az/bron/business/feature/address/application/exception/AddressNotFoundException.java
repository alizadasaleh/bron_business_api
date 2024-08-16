package az.bron.business.feature.address.application.exception;

import az.gov.dlp.exception.NotFoundException;
import az.gov.dlp.exception.model.ErrorDetails;

public class AddressNotFoundException extends NotFoundException {
    public AddressNotFoundException() {
        super(ErrorDetails.of("", "Address not found",
                "",
                ErrorDetails.error(314_00, "AddressNotFound")));
    }
}
