package az.bron.business.feature.master.application.model.request;

import lombok.Data;


@Data
public class CreateMasterRequest {
    private String name;
    private String description;
    private Long companyId;

}
