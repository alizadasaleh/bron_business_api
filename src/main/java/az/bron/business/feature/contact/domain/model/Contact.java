package az.bron.business.feature.contact.domain.model;

import az.bron.business.feature.address.domain.model.Address;
import az.bron.domain.model.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Contact extends BaseDomain<Long> {
    private String phoneNumber;
    private String email;
    private String website;
    private String additionalPhoneNumber;
    private String additionalEmail;
    private Schedule schedule;
    private Address address;
}
