package az.bron.business.feature.providedservice.application.model.response;

import lombok.Data;

import az.bron.business.feature.providedservice.domain.model.Duration;

@Data
public class GetProvidedServiceResponse {
    private Long id;
    private String name;
    private String description;
    private Duration duration;
    private Long companyId;
    private String coverImageUrl;


}
