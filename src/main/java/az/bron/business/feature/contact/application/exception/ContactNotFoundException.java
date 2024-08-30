package az.bron.business.feature.contact.application.exception;

import az.gov.dlp.exception.NotFoundException;
import az.gov.dlp.exception.model.ErrorDetails;

public class ContactNotFoundException extends NotFoundException {
    public ContactNotFoundException() {
        super(ErrorDetails.of("", "Contact not found",
                "",
                ErrorDetails.error(314_00, "ContactNotFound")));
    }
}
