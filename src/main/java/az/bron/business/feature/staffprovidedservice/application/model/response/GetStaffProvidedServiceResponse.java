package az.bron.business.feature.staffprovidedservice.application.model.response;

import lombok.Data;

@Data
public class GetStaffProvidedServiceResponse {
    private Long id;
    private Long staffId;
    private Long serviceId;
    private Double price;
    private String coverImageUrl;

}