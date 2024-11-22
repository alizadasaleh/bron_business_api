package az.bron.business.feature.role.application.exception;

import az.gov.dlp.exception.NotFoundException;
import az.gov.dlp.exception.model.ErrorDetails;

public class RoleNotFoundException extends NotFoundException {
    public RoleNotFoundException(String message) {
        super(ErrorDetails.of("", "Role not found",
                message,
                ErrorDetails.error(314_00, "RoleNotFound")));
    }

    public RoleNotFoundException() {
        super(ErrorDetails.of("", "Role not found",
                "",
                ErrorDetails.error(314_00, "RoleNotFound")));
    }
}
