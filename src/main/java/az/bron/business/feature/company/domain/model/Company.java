package az.bron.business.feature.company.domain.model;

import az.bron.domain.model.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Company extends BaseDomain<Long> {
}
