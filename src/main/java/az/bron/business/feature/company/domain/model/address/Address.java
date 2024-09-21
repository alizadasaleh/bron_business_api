package az.bron.business.feature.company.domain.model.address;

import jakarta.persistence.Embeddable;
import lombok.Data;


@Data
@Embeddable
public class Address {

    private Double latitude;
    private Double longitude;
    private String postalCode;
    private String city;
    private String state;
    private String street;
}
