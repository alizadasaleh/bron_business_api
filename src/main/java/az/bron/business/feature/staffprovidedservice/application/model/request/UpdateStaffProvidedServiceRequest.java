package az.bron.business.feature.staffprovidedservice.application.model.request;

import lombok.Data;

@Data
public class UpdateStaffProvidedServiceRequest {
    private Long staffId;
    private Long serviceId;
    private Double price;
}
