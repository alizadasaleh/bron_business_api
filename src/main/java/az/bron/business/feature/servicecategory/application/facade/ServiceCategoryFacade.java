package az.bron.business.feature.servicecategory.application.facade;

import az.bron.business.feature.servicecategory.application.model.request.CreateServiceCategoryRequest;
import az.bron.business.feature.servicecategory.application.model.request.UpdateServiceCategoryRequest;
import az.bron.business.feature.servicecategory.application.model.response.CreateServiceCategoryResponse;
import az.bron.business.feature.servicecategory.application.model.response.GetServiceCategoryResponse;
import az.bron.business.feature.servicecategory.application.model.response.UpdateServiceCategoryResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ServiceCategoryFacade {
    CreateServiceCategoryResponse create(CreateServiceCategoryRequest request);

    UpdateServiceCategoryResponse update(Integer id, UpdateServiceCategoryRequest request);

    GetServiceCategoryResponse get(Integer id);

    List<GetServiceCategoryResponse> getAll();

    void delete(Integer id);

    void uploadCoverImage(Long id, MultipartFile file) throws IOException;
}
