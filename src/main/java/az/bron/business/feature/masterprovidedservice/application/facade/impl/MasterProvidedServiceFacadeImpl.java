package az.bron.business.feature.masterprovidedservice.application.facade.impl;

import az.bron.business.config.S3Service;
import az.bron.business.feature.masterprovidedservice.application.facade.MasterProvidedServiceFacade;
import az.bron.business.feature.masterprovidedservice.application.mapper.MasterProvidedServiceMapper;
import az.bron.business.feature.masterprovidedservice.application.model.request.CreateMasterProvidedServiceRequest;
import az.bron.business.feature.masterprovidedservice.application.model.request.UpdateMasterProvidedServiceRequest;
import az.bron.business.feature.masterprovidedservice.application.model.response.CreateMasterProvidedServiceResponse;
import az.bron.business.feature.masterprovidedservice.application.model.response.GetMasterProvidedServiceResponse;
import az.bron.business.feature.masterprovidedservice.application.model.response.UpdateMasterProvidedServiceResponse;
import az.bron.business.feature.masterprovidedservice.domain.service.MasterProvidedServiceService;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Log4j2
@Service
@RequiredArgsConstructor
public class MasterProvidedServiceFacadeImpl implements MasterProvidedServiceFacade {
    private final MasterProvidedServiceService masterProvidedServiceService;
    private final MasterProvidedServiceMapper masterProvidedServiceMapper;
    private final S3Service s3Service;

    @Override
    public CreateMasterProvidedServiceResponse create(CreateMasterProvidedServiceRequest request) {
        var masterProvidedServiceModel = masterProvidedServiceMapper.toModel(request);
        var masterprovidedservice = masterProvidedServiceService.create(masterProvidedServiceModel);

        return masterProvidedServiceMapper.toCreateResponse(masterprovidedservice);
    }

    @Override
    public UpdateMasterProvidedServiceResponse update(Long id, UpdateMasterProvidedServiceRequest request) {
        var masterProvidedServiceModel = masterProvidedServiceMapper.toModel(request);

        var existingMasterProvidedService = masterProvidedServiceService.get(id);

        if (existingMasterProvidedService.isEmpty()) {
            throw new RuntimeException("MasterProvidedService with id " + id + " does not exist");
        }

        masterProvidedServiceModel.setId(id);

        var masterprovidedservice = masterProvidedServiceService.create(masterProvidedServiceModel);

        return masterProvidedServiceMapper.toUpdateResponse(masterprovidedservice);
    }

    @Override
    public GetMasterProvidedServiceResponse get(Long id) {
        var existingMasterProvidedService = masterProvidedServiceService.get(id);

        if (existingMasterProvidedService.isEmpty()) {
            throw new RuntimeException("MasterProvidedService with id " + id + " does not exist");
        }

        var masterprovidedservice = existingMasterProvidedService.get();

        return masterProvidedServiceMapper.toGetResponse(masterprovidedservice);
    }

    @Override
    public List<GetMasterProvidedServiceResponse> getAll() {
        var result = masterProvidedServiceService.getAll();

        return result.stream()
                .map(masterProvidedServiceMapper::toGetResponse)
                .toList();
    }

    @Override
    public void delete(Long id) {
        var existingMasterProvidedService = masterProvidedServiceService.get(id);

        if (existingMasterProvidedService.isEmpty()) {
            throw new RuntimeException("MasterProvidedService with id " + id + " does not exist");
        }

        masterProvidedServiceService.delete(id);
    }

    @Override
    public void uploadCoverImage(Long id, MultipartFile file) throws IOException {
        String fileName = String.valueOf(UUID.randomUUID());
        String url = s3Service.uploadFile(fileName, file,  "master-provided-service/image/cover/");
        masterProvidedServiceService.updateCoverImageUrl(url, id);
    }
}
