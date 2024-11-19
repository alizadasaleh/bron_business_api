package az.bron.business.feature.providedservice.application.model.request;

import az.bron.business.feature.providedservice.domain.model.Gender;
import lombok.Data;

@Data
public class ProvidedServiceFilterRequest {
    private Gender gender;
}
