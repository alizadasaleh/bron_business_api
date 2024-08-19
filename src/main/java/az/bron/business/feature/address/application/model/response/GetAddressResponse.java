package az.bron.business.feature.address.application.model.response;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetAddressResponse {

    private Long id;
    private Double latitude;
    private Double longitude;
    private String postalCode;
    private String city;
    private String state;
    private String street;
}
