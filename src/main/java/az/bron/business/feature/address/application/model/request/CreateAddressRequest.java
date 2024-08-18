package az.bron.business.feature.address.application.model.request;

import lombok.Data;

@Data
public class CreateAddressRequest {
    private Double latitude;
    private Double longitude;
    private String postalCode;
    private String city;
    private String state;
    private String street;
}
