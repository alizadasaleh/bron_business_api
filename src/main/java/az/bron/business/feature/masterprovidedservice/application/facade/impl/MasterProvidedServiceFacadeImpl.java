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
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class MasterProvidedServiceFacadeImpl implements MasterProvidedServiceFacade {
    private final MasterProvidedServiceService masterprovidedserviceService;
    private final MasterProvidedServiceMapper masterprovidedserviceMapper;
    private S3Service s3Service;

    @Override
    public CreateMasterProvidedServiceResponse create(CreateMasterProvidedServiceRequest request) {
        var masterprovidedserviceModel = masterprovidedserviceMapper.toModel(request);
        var masterprovidedservice = masterprovidedserviceService.create(masterprovidedserviceModel);

        return masterprovidedserviceMapper.toCreateResponse(masterprovidedservice);
    }

    @Override
    public UpdateMasterProvidedServiceResponse update(Long id, UpdateMasterProvidedServiceRequest request) {
        var masterprovidedserviceModel = masterprovidedserviceMapper.toModel(request);

        var existingMasterProvidedService = masterprovidedserviceService.get(id);

        if (existingMasterProvidedService.isEmpty()) {
            throw new RuntimeException("MasterProvidedService with id " + id + " does not exist");
        }

       masterprovidedserviceModel.setId(id);

        var masterprovidedservice = masterprovidedserviceService.create(masterprovidedserviceModel);

        return masterprovidedserviceMapper.toUpdateResponse(masterprovidedservice);
    }

    @Override
    public GetMasterProvidedServiceResponse get(Long id) {
        var existingMasterProvidedService = masterprovidedserviceService.get(id);

        if (existingMasterProvidedService.isEmpty()) {
            throw new RuntimeException("MasterProvidedService with id " + id + " does not exist");
        }

        var masterprovidedservice = existingMasterProvidedService.get();

        return masterprovidedserviceMapper.toGetResponse(masterprovidedservice);
    }

    @Override
    public List<GetMasterProvidedServiceResponse> getAll() {
        var result = masterprovidedserviceService.getAll();

        return result.stream()
                .map(masterprovidedserviceMapper::toGetResponse)
                .toList();
    }

    @Override
    public void delete(Long id) {
        var existingMasterProvidedService = masterprovidedserviceService.get(id);

        if (existingMasterProvidedService.isEmpty()) {
            throw new RuntimeException("MasterProvidedService with id " + id + " does not exist");
        }

       masterprovidedserviceService.delete(id);
    }

    @Override
    public void uploadCoverImage(Long id, MultipartFile file) throws IOException {
        String fileName = String.valueOf(UUID.randomUUID());
        s3Service.uploadFile(fileName, file, "bron-business-bucket","master-provided-service/image/cover/");
        masterprovidedserviceService.updateCoverImageUrl(fileName,id);
    }
}
