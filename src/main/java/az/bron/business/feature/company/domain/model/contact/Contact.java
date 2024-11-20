package az.bron.business.feature.company.domain.model.contact;

import az.bron.business.feature.company.domain.model.address.Address;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Data
@Embeddable
public class Contact {

    private String phoneNumber;
    private String email;
    private String website;
    private String additionalPhoneNumber;
    private String additionalEmail;

    @Embedded
    private Address address;
}

