package az.bron.business.feature.providedservice.application.model.request;

import lombok.Data;

import java.time.Duration;

@Data
public class CreateProvidedServiceRequest {
    private String name;
    private String description;
    private Duration duration;
    private Long companyId;

}
