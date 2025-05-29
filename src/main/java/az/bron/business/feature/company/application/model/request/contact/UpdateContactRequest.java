package az.bron.business.feature.company.application.model.request.contact;

import lombok.Data;

@Data
public class UpdateContactRequest {
    private String phoneNumber;
    private String email;
    private String website;
    private String additionalPhoneNumber;
    private String additionalEmail;
}
