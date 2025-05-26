package az.bron.business.feature.company.application.model.response;

import az.bron.business.common.model.Location;
import lombok.Data;

@Data
public class CompanySearchResponse {
    private Long id;
    private String name;
    private Location location;
    private Double distance;
}