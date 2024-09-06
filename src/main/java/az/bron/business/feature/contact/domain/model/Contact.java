package az.bron.business.feature.contact.domain.model;

import az.bron.business.common.Auditable;
import az.bron.business.feature.address.domain.model.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;


import java.time.LocalDateTime;

@Data
@Embeddable
public class Contact {

    private String phoneNumber;
    private String email;
    private String website;
    private String additionalPhoneNumber;
    private String additionalEmail;

    @Column(columnDefinition = "json")
    @JdbcTypeCode(SqlTypes.JSON)
    private Schedule schedule;

    @Embedded
    private Address address;
}

