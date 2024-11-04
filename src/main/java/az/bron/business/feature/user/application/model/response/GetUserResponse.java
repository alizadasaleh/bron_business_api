package az.bron.business.feature.user.application.model.response;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class GetUserResponse {
    private Long id;
    private String fullName;
    private String email;
}
