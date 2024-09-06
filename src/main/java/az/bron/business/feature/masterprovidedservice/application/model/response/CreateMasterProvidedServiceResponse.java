package az.bron.business.feature.masterprovidedservice.application.model.response;

import az.bron.business.feature.master.domain.model.Master;
import az.bron.business.feature.providedservice.domain.model.ProvidedService;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class CreateMasterProvidedServiceResponse {
    private Long id;

    private Long masterId;

    private Long serviceId;

    private Double price;
}
