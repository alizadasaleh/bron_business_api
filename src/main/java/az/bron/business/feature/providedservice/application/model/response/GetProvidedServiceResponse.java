package az.bron.business.feature.providedservice.application.model.response;

import az.bron.business.feature.master.application.model.response.GetMasterResponse;
import lombok.Data;

import java.time.Duration;
import java.util.List;

@Data
public class GetProvidedServiceResponse {
    private Long id;
    private String name;
    private String description;
    private Duration duration;
    private Long companyId;
    private List<GetMasterResponse> masters;
}
