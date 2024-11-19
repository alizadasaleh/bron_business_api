package az.bron.business.feature.providedservice.domain.specification;

import az.bron.business.feature.providedservice.domain.model.Gender;
import lombok.Data;

@Data
public class ProvidedServiceFilter {
    private Gender gender;
}
