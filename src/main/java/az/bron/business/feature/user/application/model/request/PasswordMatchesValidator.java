package az.bron.business.feature.user.application.model.request;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, RegisterUserRequest> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(RegisterUserRequest request, ConstraintValidatorContext context) {
        return request.getPassword() != null && request.getPassword().equals(request.getPasswordRepeat());
    }
}
