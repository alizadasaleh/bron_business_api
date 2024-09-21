package az.bron.business.feature.staff.application.model.response;

import lombok.Data;

@Data
public class CreateStaffResponse {
    private Long id;
    private String name;
    private String description;

    private Long companyId;
}
