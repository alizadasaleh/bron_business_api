package az.bron.business.feature.review.application.excpetion;

import az.gov.dlp.exception.AlreadyExistsException;
import az.gov.dlp.exception.NotFoundException;
import az.gov.dlp.exception.model.ErrorDetails;

public class ReviewAlreadyExistsException extends AlreadyExistsException {
    public ReviewAlreadyExistsException() {
        super(ErrorDetails.of("", "Review already exists",
                "",
                ErrorDetails.error(314_00, "ReviewAlreadyExistsException")));
    }
}
