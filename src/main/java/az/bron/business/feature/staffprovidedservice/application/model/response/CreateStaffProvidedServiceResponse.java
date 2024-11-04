package az.bron.business.feature.staffprovidedservice.application.model.response;

import lombok.Data;

@Data
public class CreateStaffProvidedServiceResponse {
    private Long id;

    private Long staffId;

    private Long serviceId;

    private Double price;
}
