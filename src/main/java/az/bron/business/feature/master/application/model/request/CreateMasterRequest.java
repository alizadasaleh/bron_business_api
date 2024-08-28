package az.bron.business.feature.master.application.model.request;

import az.bron.business.feature.company.domain.model.Company;
import az.bron.business.feature.providedservice.domain.model.ProvidedService;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CreateMasterRequest {
    private String name;
    private String description;

    private Long companyId;

//    private List<Long> servicesIds;
}
