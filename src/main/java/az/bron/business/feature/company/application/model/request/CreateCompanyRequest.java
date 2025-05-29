package az.bron.business.feature.company.application.model.request;

import az.bron.business.feature.company.application.model.request.address.CreateAddressRequest;
import az.bron.business.feature.company.application.model.request.contact.CreateContactRequest;
import lombok.Data;

@Data
public class CreateCompanyRequest {
    private String name;
    private String description;
    private CreateContactRequest contact;
    private CreateAddressRequest address;
}
