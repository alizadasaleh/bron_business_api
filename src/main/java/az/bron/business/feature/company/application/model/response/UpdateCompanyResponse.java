package az.bron.business.feature.company.application.model.response;

import az.bron.business.feature.company.application.model.response.address.UpdateAddressResponse;
import az.bron.business.feature.company.application.model.response.contact.CreateContactResponse;
import az.bron.business.feature.company.application.model.response.contact.UpdateContactResponse;
import lombok.Data;

@Data
public class UpdateCompanyResponse {
    private Long id;
    private String name;
    private String description;
    private UpdateContactResponse contact;
    private UpdateAddressResponse address;
}
