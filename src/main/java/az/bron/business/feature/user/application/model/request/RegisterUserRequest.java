package az.bron.business.feature.user.application.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@PasswordMatches
public class RegisterUserRequest {
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;


    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$",
            message = "Password must contain at least one lowercase letter, one uppercase letter, one digit, one special character (@#$%^&+=), and be at least 8 characters long"
    )
    private String password;

    @NotBlank(message = "Password confirmation is required")
    private String passwordRepeat;

    @NotBlank(message = "Full name is required")
    private String fullName;
}
