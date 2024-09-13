package az.bron.business.feature.servicecategory.application.exception;

import az.gov.dlp.exception.NotFoundException;
import az.gov.dlp.exception.model.ErrorDetails;

public class ServiceCategoryNotFoundException extends NotFoundException {
    public ServiceCategoryNotFoundException() {
        super(ErrorDetails.of("", "ServiceCategory not found",
                "",
                ErrorDetails.error(314_00, "ServiceCategoryNotFound")));
    }
}
