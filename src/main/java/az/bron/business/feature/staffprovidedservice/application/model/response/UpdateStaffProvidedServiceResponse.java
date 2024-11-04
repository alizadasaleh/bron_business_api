package az.bron.business.feature.staffprovidedservice.application.model.response;

import lombok.Data;

@Data
public class UpdateStaffProvidedServiceResponse {
    private Long id;

    private Long staffId;

    private Long serviceId;

    private Double price;

}
