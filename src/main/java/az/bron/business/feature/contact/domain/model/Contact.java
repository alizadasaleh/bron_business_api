package az.bron.business.feature.contact.domain.model;

import az.gov.dlp.domain.model.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Contact extends BaseDomain<Long> {
}
