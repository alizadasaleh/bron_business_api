package az.bron.business.feature.company.application.model.request.contact;

import az.bron.business.feature.company.domain.model.contact.Schedule;
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
