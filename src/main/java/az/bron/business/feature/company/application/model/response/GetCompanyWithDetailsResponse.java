package az.bron.business.feature.company.application.model.response;

import az.bron.business.feature.staff.application.model.response.GetStaffResponse;
import az.bron.business.feature.providedservice.application.model.response.GetProvidedServiceResponse;
import java.util.List;
import lombok.Data;

@Data
public class GetCompanyWithDetailsResponse extends GetCompanyResponse {

    private List<GetStaffResponse> staffs;
    private List<GetProvidedServiceResponse> providedServices;
}
