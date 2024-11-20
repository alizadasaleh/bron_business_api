package az.bron.business.feature.company.application.model.response.address;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetAddressResponse {

    private Double latitude;
    private Double longitude;
    private String postalCode;
    private String city;
    private String state;
    private String street;
}
