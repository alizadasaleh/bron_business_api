package az.bron.business.feature.company.application.model.request;

import az.bron.business.feature.address.application.model.request.CreateAddressRequest;
import az.bron.business.feature.address.domain.model.Address;
import az.bron.business.feature.contact.application.model.request.CreateContactRequest;
import lombok.Data;

@Data
public class CreateCompanyRequest {
    private String name;
    private String description;
    private CreateContactRequest contact;
}
