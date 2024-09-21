package az.bron.business.feature.staffprovidedservice.application.model.request;

import lombok.Data;

@Data
public class CreateStaffProvidedServiceRequest {
    private Long staffId;
    private Long serviceId;
    private Double price;
}
