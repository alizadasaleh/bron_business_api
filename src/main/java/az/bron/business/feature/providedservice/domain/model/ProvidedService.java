package az.bron.business.feature.providedservice.domain.model;

import az.bron.business.feature.company.domain.model.Company;
import az.bron.business.feature.servicetype.domain.model.ServiceType;
import az.bron.domain.model.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProvidedService extends BaseDomain<Long> {
    private Company company;
    private String name;
    private String description;
    private String price;
    private ServiceType serviceType;
}
