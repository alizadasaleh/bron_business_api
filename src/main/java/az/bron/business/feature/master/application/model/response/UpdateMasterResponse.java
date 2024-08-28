package az.bron.business.feature.master.application.model.response;

import lombok.Data;

@Data
public class UpdateMasterResponse {
    private Long id;
    private String name;
    private String description;

    private Long companyId;

}
