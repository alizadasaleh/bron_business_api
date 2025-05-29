package az.bron.business.feature.company.application.model.request;

import az.bron.business.feature.company.application.model.request.address.CreateAddressRequest;
import az.bron.business.feature.company.application.model.request.address.UpdateAddressRequest;
import az.bron.business.feature.company.application.model.request.contact.CreateContactRequest;
import az.bron.business.feature.company.application.model.request.contact.UpdateContactRequest;
import lombok.Data;

@Data
public class UpdateCompanyRequest {
    private String name;
    private String description;
    private UpdateContactRequest contact;
    private UpdateAddressRequest address;
}
