package az.bron.business.feature.masterprovidedservice.application.model.response;

import az.bron.business.feature.master.application.model.response.GetMasterResponse;
import az.bron.business.feature.providedservice.application.model.response.GetProvidedServiceResponse;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

@Data
public class GetMasterProvidedServiceResponse {
    private Long id;
    private Long masterId;
    private Long serviceId;
    private Double price;
    private String coverImageUrl;

}