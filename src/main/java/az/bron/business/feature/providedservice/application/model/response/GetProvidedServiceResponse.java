package az.bron.business.feature.providedservice.application.model.response;

import az.bron.business.feature.master.application.model.response.GetMasterResponse;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import az.bron.business.feature.providedservice.application.model.request.Duration;
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
