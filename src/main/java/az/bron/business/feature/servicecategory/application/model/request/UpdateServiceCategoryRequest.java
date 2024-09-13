package az.bron.business.feature.servicecategory.application.model.request;

import lombok.Data;

@Data
public class UpdateServiceCategoryRequest {
    private String name;
    private String description;
}
