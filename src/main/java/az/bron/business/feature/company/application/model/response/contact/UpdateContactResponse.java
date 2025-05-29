package az.bron.business.feature.company.application.model.response.contact;

import lombok.Data;

@Data
public class UpdateContactResponse {
    private Long id;
    private String phoneNumber;
    private String email;
    private String website;
    private String additionalPhoneNumber;
    private String additionalEmail;
}
