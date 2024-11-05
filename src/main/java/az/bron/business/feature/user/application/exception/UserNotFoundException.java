package az.bron.business.feature.user.application.exception;

import az.gov.dlp.exception.NotFoundException;
import az.gov.dlp.exception.model.ErrorDetails;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException() {
        super(ErrorDetails.of("", "User not found",
                "",
                ErrorDetails.error(314_00, "UserNotFound")));
    }
    public UserNotFoundException(String message) {
        super(ErrorDetails.of("", "User not found",
                message,
                ErrorDetails.error(314_00, "UserNotFound")));
    }
}
