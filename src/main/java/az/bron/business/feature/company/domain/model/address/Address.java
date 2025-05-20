package az.bron.business.feature.company.domain.model.address;

import az.bron.business.common.model.Location;
import jakarta.persistence.Embeddable;
import lombok.Data;


@Data
@Embeddable
public class Address {
    private Location location;
    private String postalCode;
    private String city;
    private String state;
    private String street;
}
