package az.bron.business.feature.company.application.model.response.contact;

import az.bron.business.feature.company.application.model.response.address.GetAddressResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetContactResponse {
    private String phoneNumber;
    private String email;
    private String website;
    private String additionalPhoneNumber;
    private String additionalEmail;
    private GetAddressResponse address;
}
