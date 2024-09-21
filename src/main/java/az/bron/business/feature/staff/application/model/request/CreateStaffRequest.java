package az.bron.business.feature.staff.application.model.request;

import lombok.Data;


@Data
public class CreateStaffRequest {
    private String name;
    private String description;
    private Long companyId;

}
