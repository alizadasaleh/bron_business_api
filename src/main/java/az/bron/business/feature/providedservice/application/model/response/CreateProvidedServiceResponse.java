package az.bron.business.feature.providedservice.application.model.response;

import az.bron.business.feature.providedservice.domain.model.Duration;
import lombok.Data;

@Data
public class CreateProvidedServiceResponse {
    private Long id;
    private String name;
    private String description;
    private Duration duration;
    private Long companyId;
}
