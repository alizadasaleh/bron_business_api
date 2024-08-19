package az.bron.business.feature.company.application.model.request;

import lombok.Data;

@Data
public class UpdateCompanyRequest {
    private String name;
    private String description;
    private Long contactId;
}
