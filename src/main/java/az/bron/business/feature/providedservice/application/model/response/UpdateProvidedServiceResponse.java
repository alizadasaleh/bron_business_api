package az.bron.business.feature.providedservice.application.model.response;

import java.time.Duration;
import lombok.Data;

@Data
public class UpdateProvidedServiceResponse {
    private Long id;
    private String name;
    private String description;
    private Duration duration;
    private Long companyId;

}
