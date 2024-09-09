package az.bron.business.feature.providedservice.application.model.response;

import az.bron.business.feature.master.application.model.response.GetMasterResponse;
import az.bron.business.feature.servicecategory.application.model.response.GetServiceCategoryResponse;
import az.bron.business.feature.servicecategory.domain.model.ServiceCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import az.bron.business.feature.providedservice.domain.model.Duration;
import java.util.List;

@Data
public class GetProvidedServiceResponse {
    private Long id;
    private String name;
    private String description;
    private Duration duration;
    private Long companyId;

}
