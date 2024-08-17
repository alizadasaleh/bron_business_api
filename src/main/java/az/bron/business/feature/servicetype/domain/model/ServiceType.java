package az.bron.business.feature.servicetype.domain.model;

import az.bron.domain.model.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ServiceType extends BaseDomain<Long> {
    private String name;
}
