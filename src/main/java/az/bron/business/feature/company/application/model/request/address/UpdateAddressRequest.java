package az.bron.business.feature.company.application.model.request.address;

import az.bron.business.common.model.Location;
import lombok.Data;

@Data
public class UpdateAddressRequest {
    private Location location;
    private String postalCode;
    private String city;
    private String state;
    private String street;
}
