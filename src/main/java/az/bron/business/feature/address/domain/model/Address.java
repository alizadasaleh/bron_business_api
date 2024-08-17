package az.bron.business.feature.address.domain.model;

import az.bron.domain.model.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Address extends BaseDomain<Long> {
}
