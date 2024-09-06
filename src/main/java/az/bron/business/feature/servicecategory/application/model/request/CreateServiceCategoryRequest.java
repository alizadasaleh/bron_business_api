package az.bron.business.feature.servicecategory.application.model.request;

import lombok.Data;

@Data
public class CreateServiceCategoryRequest {
    private String name;
    private String description;
}
