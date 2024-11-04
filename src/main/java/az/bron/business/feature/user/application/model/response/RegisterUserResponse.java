package az.bron.business.feature.user.application.model.response;


import lombok.Data;

@Data
public class RegisterUserResponse {
    private String fullName;

    private String email;

    private String password;
}
