package az.bron.business.feature.company.application.exception;

import az.gov.dlp.exception.NotFoundException;
import az.gov.dlp.exception.model.ErrorDetails;

public class CompanyNotFoundException extends NotFoundException {
    public CompanyNotFoundException() {
        super(ErrorDetails.of("", "Company not found",
                "",
                ErrorDetails.error(314_00, "CompanyNotFound")));
    }
}
