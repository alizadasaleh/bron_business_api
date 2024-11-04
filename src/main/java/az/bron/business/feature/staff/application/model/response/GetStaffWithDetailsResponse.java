package az.bron.business.feature.staff.application.model.response;

import az.bron.business.feature.staffprovidedservice.application.model.response.GetCertainProvidedServiceResponse;
import java.util.List;
import lombok.Data;

@Data
public class GetStaffWithDetailsResponse extends GetStaffResponse {


    private List<GetCertainProvidedServiceResponse> services;
}
