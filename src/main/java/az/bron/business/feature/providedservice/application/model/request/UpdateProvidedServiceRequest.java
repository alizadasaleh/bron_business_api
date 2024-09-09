package az.bron.business.feature.providedservice.application.model.request;

import az.bron.business.feature.providedservice.domain.model.Duration;
import lombok.Data;

@Data
public class UpdateProvidedServiceRequest {
    private String name;
    private String description;
    private Duration duration;
    private Long companyId;
}
