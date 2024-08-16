package az.bron.business.feature.organization.domain.model;

import az.gov.dlp.domain.model.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Organization extends BaseDomain<Long> {
}
