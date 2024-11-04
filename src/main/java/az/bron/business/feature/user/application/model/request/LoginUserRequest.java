package az.bron.business.feature.user.application.model.request;

import lombok.Data;

@Data
public class LoginUserRequest {
    private String email;

    private String password;

}
