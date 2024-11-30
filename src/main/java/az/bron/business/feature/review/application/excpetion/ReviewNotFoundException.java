package az.bron.business.feature.review.application.excpetion;

import az.gov.dlp.exception.NotFoundException;
import az.gov.dlp.exception.model.ErrorDetails;

public class ReviewNotFoundException extends NotFoundException {
    public ReviewNotFoundException(String message) {
        super(ErrorDetails.of("", "Review not found",
                message,
                ErrorDetails.error(314_00, "ReviewNotFound")));
    }
}
