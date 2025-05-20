package az.bron.business.feature.company.application.model.response.contact;

import az.bron.business.feature.company.application.model.response.address.CreateAddressResponse;
import lombok.Data;

@Data
public class CreateContactResponse {
    private String phoneNumber;
    private String email;
    private String website;
    private String additionalPhoneNumber;
    private String additionalEmail;
}
