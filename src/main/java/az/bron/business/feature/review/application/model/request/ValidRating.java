package az.bron.business.feature.review.application.model.request;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RatingValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRating {
    String message() default "Rating must be one of [1.5, 2, 2.5, 3, ..., 5]";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

