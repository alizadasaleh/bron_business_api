package az.bron.business.feature.address.domain.model;

import az.bron.domain.model.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Address extends BaseDomain<Long> {
    private Double latitude;
    private Double longitude;
    private String postalCode;
    private String city;
    private String state;
    private String street;

}
