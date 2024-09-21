package az.bron.business.feature.providedservice.application.model.response;

import az.bron.business.feature.staff.application.model.response.GetStaffResponse;
import az.bron.business.feature.servicecategory.application.model.response.GetServiceCategoryResponse;
import java.util.List;
import lombok.Data;

@Data
public class GetProvidedServiceWithDetailsResponse extends GetProvidedServiceResponse {
    private List<GetStaffResponse> staffs;
    private GetServiceCategoryResponse category;
}
