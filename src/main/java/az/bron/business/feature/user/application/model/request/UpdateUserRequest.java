package az.bron.business.feature.user.application.model.request;

import az.bron.business.feature.role.domain.model.RoleEnum;
import lombok.Data;

@Data
public class UpdateUserRequest {
    private String fullName;
    private String email;
    private String password;
    private RoleEnum role;
}
