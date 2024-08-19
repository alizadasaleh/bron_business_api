package az.bron.business.feature.contact.application.model.response;

import az.bron.business.feature.address.application.model.response.GetAddressResponse;
import az.bron.business.feature.contact.domain.model.Schedule;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetContactResponse {
    private Long id;
    private String phoneNumber;
    private String email;
    private String website;
    private String additionalPhoneNumber;
    private String additionalEmail;
    private Schedule schedule;
    private GetAddressResponse address;
}
