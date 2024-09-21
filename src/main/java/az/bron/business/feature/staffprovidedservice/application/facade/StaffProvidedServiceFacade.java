package az.bron.business.feature.staffprovidedservice.application.facade;

import az.bron.business.feature.staffprovidedservice.application.model.request.CreateStaffProvidedServiceRequest;
import az.bron.business.feature.staffprovidedservice.application.model.request.UpdateStaffProvidedServiceRequest;
import az.bron.business.feature.staffprovidedservice.application.model.response.CreateStaffProvidedServiceResponse;
import az.bron.business.feature.staffprovidedservice.application.model.response.GetStaffProvidedServiceResponse;
import az.bron.business.feature.staffprovidedservice.application.model.response.UpdateStaffProvidedServiceResponse;
import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface StaffProvidedServiceFacade {
    CreateStaffProvidedServiceResponse create(CreateStaffProvidedServiceRequest request);

    UpdateStaffProvidedServiceResponse update(Long id, UpdateStaffProvidedServiceRequest request);

    GetStaffProvidedServiceResponse get(Long id);

    List<GetStaffProvidedServiceResponse> getAll();

    void delete(Long id);

    void uploadCoverImage(Long id, MultipartFile file) throws IOException;
}
