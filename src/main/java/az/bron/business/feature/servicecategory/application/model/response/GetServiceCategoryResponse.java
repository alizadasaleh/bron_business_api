package az.bron.business.feature.servicecategory.application.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class GetServiceCategoryResponse {
    private Integer id;
    private String name;
    private String description;
    private String coverImageUrl;
}
