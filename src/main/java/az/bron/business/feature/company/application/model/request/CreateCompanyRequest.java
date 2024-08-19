package az.bron.business.feature.company.application.model.request;

import az.bron.business.feature.address.domain.model.Address;
import lombok.Data;

@Data
public class CreateCompanyRequest {
    private String name;
    private String description;
    private Long contactId;

}
