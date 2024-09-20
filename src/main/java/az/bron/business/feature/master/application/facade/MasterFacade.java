package az.bron.business.feature.master.application.facade;

import az.bron.business.feature.master.application.model.request.CreateMasterRequest;
import az.bron.business.feature.master.application.model.request.UpdateMasterRequest;
import az.bron.business.feature.master.application.model.response.CreateMasterResponse;
import az.bron.business.feature.master.application.model.response.GetMasterResponse;
import az.bron.business.feature.master.application.model.response.UpdateMasterResponse;

import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface MasterFacade {
    CreateMasterResponse create(CreateMasterRequest request);

    UpdateMasterResponse update(Long id, UpdateMasterRequest request);

    GetMasterResponse get(Long id);

    List<GetMasterResponse> getAll();

    void delete(Long id);

    void uploadProfileImage(Long id, MultipartFile file) throws IOException;
}
