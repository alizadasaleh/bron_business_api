package az.bron.business.feature.staffprovidedservice.application.facade.impl;

import az.bron.business.config.S3Service;
import az.bron.business.feature.staffprovidedservice.application.exception.StaffProvidedServiceNotFoundException;
import az.bron.business.feature.staffprovidedservice.application.facade.StaffProvidedServiceFacade;
import az.bron.business.feature.staffprovidedservice.application.mapper.StaffProvidedServiceMapper;
import az.bron.business.feature.staffprovidedservice.application.model.request.CreateStaffProvidedServiceRequest;
import az.bron.business.feature.staffprovidedservice.application.model.request.UpdateStaffProvidedServiceRequest;
import az.bron.business.feature.staffprovidedservice.application.model.response.CreateStaffProvidedServiceResponse;
import az.bron.business.feature.staffprovidedservice.application.model.response.GetStaffProvidedServiceResponse;
import az.bron.business.feature.staffprovidedservice.application.model.response.UpdateStaffProvidedServiceResponse;
import az.bron.business.feature.staffprovidedservice.domain.service.StaffProvidedServiceService;
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
public class StaffProvidedServiceFacadeImpl implements StaffProvidedServiceFacade {
    private final StaffProvidedServiceService staffProvidedServiceService;
    private final StaffProvidedServiceMapper staffProvidedServiceMapper;
    private final S3Service s3Service;

    @Override
    public CreateStaffProvidedServiceResponse create(CreateStaffProvidedServiceRequest request) {
        var staffProvidedServiceModel = staffProvidedServiceMapper.toModel(request);
        var staffprovidedservice = staffProvidedServiceService.create(staffProvidedServiceModel);

        return staffProvidedServiceMapper.toCreateResponse(staffprovidedservice);
    }

    @Override
    public UpdateStaffProvidedServiceResponse update(Long id, UpdateStaffProvidedServiceRequest request) {
        var staffProvidedServiceModel = staffProvidedServiceMapper.toModel(request);

        var existingStaffProvidedService = staffProvidedServiceService.get(id);

        if (existingStaffProvidedService.isEmpty()) {
            throw new StaffProvidedServiceNotFoundException("StaffProvidedService with id " + id + " does not exist");
        }

        staffProvidedServiceModel.setId(id);

        var staffprovidedservice = staffProvidedServiceService.create(staffProvidedServiceModel);

        return staffProvidedServiceMapper.toUpdateResponse(staffprovidedservice);
    }

    @Override
    public GetStaffProvidedServiceResponse get(Long id) {
        var existingStaffProvidedService = staffProvidedServiceService.get(id);

        if (existingStaffProvidedService.isEmpty()) {
            throw new StaffProvidedServiceNotFoundException("StaffProvidedService with id " + id + " does not exist");
        }

        var staffprovidedservice = existingStaffProvidedService.get();

        return staffProvidedServiceMapper.toGetResponse(staffprovidedservice);
    }

    @Override
    public List<GetStaffProvidedServiceResponse> getAll() {
        var result = staffProvidedServiceService.getAll();

        return result.stream()
                .map(staffProvidedServiceMapper::toGetResponse)
                .toList();
    }

    @Override
    public void delete(Long id) {
        var existingStaffProvidedService = staffProvidedServiceService.get(id);

        if (existingStaffProvidedService.isEmpty()) {
            throw new StaffProvidedServiceNotFoundException("StaffProvidedService with id " + id + " does not exist");
        }

        staffProvidedServiceService.delete(id);
    }

    @Override
    public void uploadCoverImage(Long id, MultipartFile file) throws IOException {
        String fileName = String.valueOf(UUID.randomUUID());
        String url = s3Service.uploadFile(fileName, file, "staff-provided-service/image/cover/");
        staffProvidedServiceService.updateCoverImageUrl(url, id);
    }
}
