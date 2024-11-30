package az.bron.business.feature.review.application.excpetion;

import az.gov.dlp.exception.ForbiddenException;
import az.gov.dlp.exception.model.ErrorDetails;

public class UnauthorizedReviewManipulationException extends ForbiddenException {

    public UnauthorizedReviewManipulationException(String message) {
        super(ErrorDetails.of("", "No rights to do this",
                message,
                ErrorDetails.error(314_00, "UnauthorizedReviewManipulation")));
    }

    public UnauthorizedReviewManipulationException(Long userId, Long appointmentId ) {
        super(ErrorDetails.of("", "No rights to do this",
                "User with id " + userId + " cannot do anything with an appointment with id " + appointmentId,
                ErrorDetails.error(314_00, "UnauthorizedReviewManipulation")));
    }
}
