package az.bron.business.feature.masterprovidedservice.application.model.request;

import lombok.Data;

@Data
public class UpdateMasterProvidedServiceRequest {
    private Long masterId;
    private Long serviceId;
    private Double price;
}
