package az.bron.business.feature.servicecategory.application.facade.impl;

import az.bron.business.config.S3Service;
import az.bron.business.feature.servicecategory.application.exception.ServiceCategoryNotFoundException;
import az.bron.business.feature.servicecategory.application.facade.ServiceCategoryFacade;
import az.bron.business.feature.servicecategory.application.mapper.ServiceCategoryMapper;
import az.bron.business.feature.servicecategory.application.model.request.CreateServiceCategoryRequest;
import az.bron.business.feature.servicecategory.application.model.request.UpdateServiceCategoryRequest;
import az.bron.business.feature.servicecategory.application.model.response.CreateServiceCategoryResponse;
import az.bron.business.feature.servicecategory.application.model.response.GetServiceCategoryResponse;
import az.bron.business.feature.servicecategory.application.model.response.UpdateServiceCategoryResponse;
import az.bron.business.feature.servicecategory.domain.service.ServiceCategoryService;
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
public class ServiceCategoryFacadeImpl implements ServiceCategoryFacade {
    private final ServiceCategoryService serviceCategoryService;
    private final ServiceCategoryMapper serviceCategoryMapper;
    private final S3Service s3Service;

    @Override
    public CreateServiceCategoryResponse create(CreateServiceCategoryRequest request) {
        var serviceCategoryModel = serviceCategoryMapper.toModel(request);
        var servicecategory = serviceCategoryService.create(serviceCategoryModel);

        return serviceCategoryMapper.toCreateResponse(servicecategory);
    }

    @Override
    public UpdateServiceCategoryResponse update(Integer id, UpdateServiceCategoryRequest request) {
        var serviceCategoryModel = serviceCategoryMapper.toModel(request);

        var existingServiceCategory = serviceCategoryService.get(id);

        if (existingServiceCategory.isEmpty()) {
            throw new ServiceCategoryNotFoundException();
        }

        serviceCategoryModel.setId(id);

        var servicecategory = serviceCategoryService.create(serviceCategoryModel);

        return serviceCategoryMapper.toUpdateResponse(servicecategory);
    }

    @Override
    public GetServiceCategoryResponse get(Integer id) {
        var existingServiceCategory = serviceCategoryService.get(id);

        if (existingServiceCategory.isEmpty()) {
            throw new ServiceCategoryNotFoundException();
        }

        var servicecategory = existingServiceCategory.get();

        return serviceCategoryMapper.toGetResponse(servicecategory);
    }

    @Override
    public List<GetServiceCategoryResponse> getAll() {
        var result = serviceCategoryService.getAll();

        return result.stream()
                .map(serviceCategoryMapper::toGetResponse)
                .toList();
    }

    @Override
    public void delete(Integer id) {
        var existingServiceCategory = serviceCategoryService.get(id);

        if (existingServiceCategory.isEmpty()) {
            throw new ServiceCategoryNotFoundException();
        }

        serviceCategoryService.delete(id);
    }

    @Override
    public void uploadCoverImage(Long id, MultipartFile file) throws IOException {
        String fileName = String.valueOf(UUID.randomUUID());
        String url = s3Service.uploadFile(fileName, file, "service-category/image/cover/");
        serviceCategoryService.updateCoverImageUrl(url, id);
    }
}
