package az.bron.business.feature.company.application.model.response.contact;

import az.bron.business.feature.company.domain.model.contact.Schedule;
import lombok.Data;

@Data
public class UpdateContactResponse {
    private Long id;
    private String phoneNumber;
    private String email;
    private String website;
    private String additionalPhoneNumber;
    private String additionalEmail;
    private Schedule schedule;
    private Long addressId;
}
