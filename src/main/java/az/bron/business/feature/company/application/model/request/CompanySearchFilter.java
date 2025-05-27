package az.bron.business.feature.company.application.model.request;

import az.bron.business.common.model.Location;
import az.bron.business.feature.providedservice.domain.model.Gender;
import lombok.Data;

@Data
public class CompanySearchFilter {
    private String query;
    private Double radius;
    private Double latitude;
    private Double longitude;
    private Gender gender;

}
