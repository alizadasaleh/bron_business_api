package az.bron.business.feature.masterprovidedservice.application.model.response;

import lombok.Data;

@Data
public class GetMasterProvidedServiceResponse {
    private Long id;
    private Long masterId;
    private Long serviceId;
    private Double price;
}
