package az.bron.business.feature.servicecategory.application.facade.impl;

import az.bron.business.config.S3Service;
import az.bron.business.feature.masterprovidedservice.domain.service.MasterProvidedServiceService;
import az.bron.business.feature.servicecategory.application.exception.ServiceCategoryNotFoundException;
import az.bron.business.feature.servicecategory.application.facade.ServiceCategoryFacade;
import az.bron.business.feature.servicecategory.application.mapper.ServiceCategoryMapper;
import az.bron.business.feature.servicecategory.application.model.request.CreateServiceCategoryRequest;
import az.bron.business.feature.servicecategory.application.model.request.UpdateServiceCategoryRequest;
import az.bron.business.feature.servicecategory.application.model.response.CreateServiceCategoryResponse;
import az.bron.business.feature.servicecategory.application.model.response.GetServiceCategoryResponse;
import az.bron.business.feature.servicecategory.application.model.response.UpdateServiceCategoryResponse;
import az.bron.business.feature.servicecategory.domain.service.ServiceCategoryService;
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
public class ServiceCategoryFacadeImpl implements ServiceCategoryFacade {
    private final ServiceCategoryService servicecategoryService;
    private final ServiceCategoryMapper servicecategoryMapper;
    private final S3Service s3Service;
    private final MasterProvidedServiceService providedserviceService;

    @Override
    public CreateServiceCategoryResponse create(CreateServiceCategoryRequest request) {
        var servicecategoryModel = servicecategoryMapper.toModel(request);
        var servicecategory = servicecategoryService.create(servicecategoryModel);

        return servicecategoryMapper.toCreateResponse(servicecategory);
    }

    @Override
    public UpdateServiceCategoryResponse update(Integer id, UpdateServiceCategoryRequest request) {
        var servicecategoryModel = servicecategoryMapper.toModel(request);

        var existingServiceCategory = servicecategoryService.get(id);

        if (existingServiceCategory.isEmpty()) {
            throw new ServiceCategoryNotFoundException();
        }

       servicecategoryModel.setId(id);

        var servicecategory = servicecategoryService.create(servicecategoryModel);

        return servicecategoryMapper.toUpdateResponse(servicecategory);
    }

    @Override
    public GetServiceCategoryResponse get(Integer id) {
        var existingServiceCategory = servicecategoryService.get(id);

        if (existingServiceCategory.isEmpty()) {
            throw new ServiceCategoryNotFoundException();
        }

        var servicecategory = existingServiceCategory.get();

        return servicecategoryMapper.toGetResponse(servicecategory);
    }

    @Override
    public List<GetServiceCategoryResponse> getAll() {
        var result = servicecategoryService.getAll();

        return result.stream()
                .map(servicecategoryMapper::toGetResponse)
                .toList();
    }

    @Override
    public void delete(Integer id) {
        var existingServiceCategory = servicecategoryService.get(id);

        if (existingServiceCategory.isEmpty()) {
            throw new ServiceCategoryNotFoundException();
        }

       servicecategoryService.delete(id);
    }

    @Override
    public void uploadCoverImage(Long id, MultipartFile file) throws IOException {
        String fileName = String.valueOf(UUID.randomUUID());
        s3Service.uploadFile(fileName, file, "bron-business-bucket","company/image/cover/");
        servicecategoryService.updateCoverImageUrl(fileName,id);
    }
}
