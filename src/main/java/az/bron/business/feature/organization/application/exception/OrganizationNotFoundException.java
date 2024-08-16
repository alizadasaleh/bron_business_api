package az.bron.business.feature.organization.application.exception;

import az.gov.dlp.exception.NotFoundException;
import az.gov.dlp.exception.model.ErrorDetails;

public class OrganizationNotFoundException extends NotFoundException {
    public OrganizationNotFoundException() {
        super(ErrorDetails.of("", "Organization not found",
                "",
                ErrorDetails.error(314_00, "OrganizationNotFound")));
    }
}
