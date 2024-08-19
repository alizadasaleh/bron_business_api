package az.bron.business.feature.contact.application.model.request;

import az.bron.business.feature.contact.domain.model.Schedule;
import lombok.Data;

@Data
public class UpdateContactRequest {
    private String phoneNumber;
    private String email;
    private String website;
    private String additionalPhoneNumber;
    private String additionalEmail;
    private Schedule schedule;
    private Long addressId;
}
