package az.bron.business.feature.master.application.facade.impl;

import az.bron.business.feature.master.application.facade.MasterFacade;
import az.bron.business.feature.master.application.mapper.MasterMapper;
import az.bron.business.feature.master.application.model.request.CreateMasterRequest;
import az.bron.business.feature.master.application.model.request.UpdateMasterRequest;
import az.bron.business.feature.master.application.model.response.CreateMasterResponse;
import az.bron.business.feature.master.application.model.response.GetMasterResponse;
import az.bron.business.feature.master.application.model.response.UpdateMasterResponse;
import az.bron.business.feature.master.domain.service.MasterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class MasterFacadeImpl implements MasterFacade {
    private final MasterService masterService;
    private final MasterMapper masterMapper;

    @Override
    public CreateMasterResponse create(CreateMasterRequest request) {
        var masterModel = masterMapper.toModel(request);
        var master = masterService.create(masterModel);

        return masterMapper.toCreateResponse(master);
    }

    @Override
    public UpdateMasterResponse update(Long id, UpdateMasterRequest request) {
        var masterModel = masterMapper.toModel(request);

        var existingMaster = masterService.get(id);

        if (existingMaster.isEmpty()) {
            throw new RuntimeException("Master with id " + id + " does not exist");
        }

       masterModel.setId(id);

        var master = masterService.create(masterModel);

        return masterMapper.toUpdateResponse(master);
    }

    @Override
    public GetMasterResponse get(Long id) {
        var existingMaster = masterService.get(id);

        if (existingMaster.isEmpty()) {
            throw new RuntimeException("Master with id " + id + " does not exist");
        }

        var master = existingMaster.get();

        return masterMapper.toGetResponse(master);
    }

    @Override
    public List<GetMasterResponse> getAll() {
        var result = masterService.getAll();

        return result.stream()
                .map(masterMapper::toGetResponse)
                .toList();
    }

    @Override
    public void delete(Long id) {
        var existingMaster = masterService.get(id);

        if (existingMaster.isEmpty()) {
            throw new RuntimeException("Master with id " + id + " does not exist");
        }

       masterService.delete(id);
    }
}
