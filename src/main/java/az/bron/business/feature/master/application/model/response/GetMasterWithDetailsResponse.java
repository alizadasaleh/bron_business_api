package az.bron.business.feature.master.application.model.response;

import az.bron.business.feature.masterprovidedservice.application.model.response.GetCertainProvidedServiceResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.Data;

@Data
public class GetMasterWithDetailsResponse extends GetMasterResponse{


    private List<GetCertainProvidedServiceResponse> services;
}
