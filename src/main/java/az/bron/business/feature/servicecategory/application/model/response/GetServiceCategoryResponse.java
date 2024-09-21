package az.bron.business.feature.servicecategory.application.model.response;

import lombok.Data;

@Data
public class GetServiceCategoryResponse {
    private Integer id;
    private String name;
    private String description;
    private String coverImageUrl;
}
