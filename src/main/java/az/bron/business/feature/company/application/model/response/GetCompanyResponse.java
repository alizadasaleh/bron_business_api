package az.bron.business.feature.company.application.model.response;

import az.bron.business.feature.address.application.model.response.GetAddressResponse;
import az.bron.business.feature.address.domain.model.Address;
import az.bron.business.feature.contact.application.model.response.GetContactResponse;
import lombok.Data;

@Data
public class GetCompanyResponse {
    private Long id;
    private String name;
    private String description;
    private GetContactResponse contact;
}
