package az.bron.business.feature.providedservice.application.model.response;

import az.bron.business.feature.master.application.model.response.GetMasterResponse;
import az.bron.business.feature.providedservice.domain.model.Duration;
import az.bron.business.feature.servicecategory.application.model.response.GetServiceCategoryResponse;
import java.util.List;
import lombok.Data;

@Data
public class GetProvidedServiceWithDetailsResponse extends GetProvidedServiceResponse {
    private List<GetMasterResponse> masters;
    private GetServiceCategoryResponse category;
}
