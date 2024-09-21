package az.bron.business.feature.masterprovidedservice.application.facade;

import az.bron.business.feature.masterprovidedservice.application.model.request.CreateMasterProvidedServiceRequest;
import az.bron.business.feature.masterprovidedservice.application.model.request.UpdateMasterProvidedServiceRequest;
import az.bron.business.feature.masterprovidedservice.application.model.response.CreateMasterProvidedServiceResponse;
import az.bron.business.feature.masterprovidedservice.application.model.response.GetMasterProvidedServiceResponse;
import az.bron.business.feature.masterprovidedservice.application.model.response.UpdateMasterProvidedServiceResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MasterProvidedServiceFacade {
    CreateMasterProvidedServiceResponse create(CreateMasterProvidedServiceRequest request);

    UpdateMasterProvidedServiceResponse update(Long id, UpdateMasterProvidedServiceRequest request);

    GetMasterProvidedServiceResponse get(Long id);

    List<GetMasterProvidedServiceResponse> getAll();

    void delete(Long id);

    void uploadCoverImage(Long id, MultipartFile file) throws IOException;
}
