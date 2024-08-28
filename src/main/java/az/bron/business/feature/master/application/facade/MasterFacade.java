package az.bron.business.feature.master.application.facade;

import az.bron.business.feature.master.application.model.request.CreateMasterRequest;
import az.bron.business.feature.master.application.model.request.UpdateMasterRequest;
import az.bron.business.feature.master.application.model.response.CreateMasterResponse;
import az.bron.business.feature.master.application.model.response.GetMasterResponse;
import az.bron.business.feature.master.application.model.response.UpdateMasterResponse;

import java.util.List;

public interface MasterFacade {
    CreateMasterResponse create(CreateMasterRequest request);

    UpdateMasterResponse update(Long id, UpdateMasterRequest request);

    GetMasterResponse get(Long id);

    List<GetMasterResponse> getAll();

    void delete(Long id);
}
