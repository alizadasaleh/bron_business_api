package az.bron.business.feature.company.application.model.response.address;

import az.bron.business.common.model.Location;
import lombok.Data;

@Data
public class CreateAddressResponse {
    private Location location;
    private String postalCode;
    private String city;
    private String state;
    private String street;
}
