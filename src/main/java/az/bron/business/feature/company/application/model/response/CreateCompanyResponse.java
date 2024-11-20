package az.bron.business.feature.company.application.model.response;

import az.bron.business.feature.company.application.model.response.contact.CreateContactResponse;
import lombok.Data;

@Data
public class CreateCompanyResponse {
    private Long id;
    private String name;
    private String description;
    private CreateContactResponse contact;
}
