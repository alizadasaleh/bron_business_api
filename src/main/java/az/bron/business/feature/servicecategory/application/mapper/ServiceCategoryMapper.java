package az.bron.business.feature.servicecategory.application.mapper;

import az.bron.business.feature.servicecategory.application.model.request.CreateServiceCategoryRequest;
import az.bron.business.feature.servicecategory.application.model.request.UpdateServiceCategoryRequest;
import az.bron.business.feature.servicecategory.application.model.response.CreateServiceCategoryResponse;
import az.bron.business.feature.servicecategory.application.model.response.GetServiceCategoryResponse;
import az.bron.business.feature.servicecategory.application.model.response.UpdateServiceCategoryResponse;
import az.bron.business.feature.servicecategory.domain.model.ServiceCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServiceCategoryMapper {
    ServiceCategory toModel(CreateServiceCategoryRequest request);

    ServiceCategory toModel(UpdateServiceCategoryRequest request);

    CreateServiceCategoryResponse toCreateResponse(ServiceCategory servicecategory);

    UpdateServiceCategoryResponse toUpdateResponse(ServiceCategory servicecategory);

    GetServiceCategoryResponse toGetResponse(ServiceCategory servicecategory);
}
