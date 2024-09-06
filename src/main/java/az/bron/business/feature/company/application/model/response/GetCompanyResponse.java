package az.bron.business.feature.company.application.model.response;

import az.bron.business.feature.company.application.model.response.contact.GetContactResponse;
import az.bron.business.feature.master.application.model.response.GetMasterResponse;
import az.bron.business.feature.providedservice.application.model.response.GetProvidedServiceResponse;
import lombok.Data;

import java.util.List;

@Data
public class GetCompanyResponse {
    private Long id;
    private String name;
    private String description;
    private GetContactResponse contact;

    private List<GetMasterResponse> masters;
    private List<GetProvidedServiceResponse> providedServices;
}
