package az.bron.business.feature.company.application.model.response;

import az.bron.business.feature.company.application.model.response.address.GetAddressResponse;
import az.bron.business.feature.company.application.model.response.contact.GetContactResponse;
import lombok.Data;

@Data
public class GetCompanyResponse {
    private Long id;
    private String name;
    private String description;
    private String logoImageUrl;
    private String profileImageUrl;
    private String backgroundImageUrl;
    private GetContactResponse contact;
    private GetAddressResponse address;
}
