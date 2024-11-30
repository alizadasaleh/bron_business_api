package az.bron.business.feature.review.application.model.request;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class RatingValidator implements ConstraintValidator<ValidRating, Float> {

    private final List<Float> validRatings = Arrays.asList(1.5f, 2f, 2.5f, 3f, 3.5f, 4f, 4.5f, 5f);

    @Override
    public boolean isValid(Float value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Allow null if the field is optional
        }
        return validRatings.contains(value);
    }
}
