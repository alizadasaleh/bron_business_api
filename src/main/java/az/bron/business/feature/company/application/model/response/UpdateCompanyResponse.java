package az.bron.business.feature.company.application.model.response;

import lombok.Data;

@Data
public class UpdateCompanyResponse {
    private Long id;
    private String name;
    private String description;
    private Long contactId;
}
