package az.bron.business.feature.user.application.exception;

import az.gov.dlp.exception.AlreadyExistsException;
import az.gov.dlp.exception.model.ErrorDetails;

public class UserAlreadyExists extends AlreadyExistsException {
    public UserAlreadyExists(String email) {
        super(ErrorDetails.of("", "User already exist",
                "User with email " + email + " already exists" ,
                ErrorDetails.error(314_00, "UserAlreadyExist")));
    }
}
