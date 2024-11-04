package az.bron.business.feature.staffprovidedservice.application.model.response;

import az.bron.business.feature.staff.application.model.response.GetStaffResponse;
import az.bron.business.feature.providedservice.domain.model.Duration;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class GetCertainProvidedServiceResponse {
    private Long id;
    private String name;
    private String description;
    private Duration duration;
    private Long companyId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private GetStaffResponse staff;
    private Double price;

}
