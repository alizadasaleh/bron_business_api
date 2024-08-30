package az.bron.business.feature.masterprovidedservice.application.model.response;

import az.bron.business.feature.master.application.model.response.GetMasterResponse;
import az.bron.business.feature.providedservice.application.model.request.Duration;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.Data;

@Data
public class GetCertainProvidedServiceResponse {
    private Long id;
    private String name;
    private String description;
    private Duration duration;
    private Long companyId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private GetMasterResponse master;
    private Double price;

}
