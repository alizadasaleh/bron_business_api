package az.bron.business.feature.company.application.model.response.address;

import lombok.Data;

@Data
public class UpdateAddressResponse {
    private Long id;
    private Double latitude;
    private Double longitude;
    private String postalCode;
    private String city;
    private String state;
    private String street;
}
