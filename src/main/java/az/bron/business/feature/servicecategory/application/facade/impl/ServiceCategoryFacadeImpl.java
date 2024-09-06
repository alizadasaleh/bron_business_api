package az.bron.business.feature.servicecategory.application.facade.impl;

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

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ServiceCategoryFacadeImpl implements ServiceCategoryFacade {
    private final ServiceCategoryService servicecategoryService;
    private final ServiceCategoryMapper servicecategoryMapper;

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
}
