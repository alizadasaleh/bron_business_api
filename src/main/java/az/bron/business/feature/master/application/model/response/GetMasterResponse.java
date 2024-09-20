package az.bron.business.feature.master.application.model.response;

import az.bron.business.feature.masterprovidedservice.application.model.response.GetCertainProvidedServiceResponse;
import az.bron.business.feature.masterprovidedservice.application.model.response.GetMasterProvidedServiceResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.util.List;

@Data
public class GetMasterResponse {
    private Long id;
    private String name;
    private String description;
    private Long companyId;
    private String profileImageUrl;
}
