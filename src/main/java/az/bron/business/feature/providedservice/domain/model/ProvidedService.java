package az.bron.business.feature.providedservice.domain.model;

import az.bron.business.common.Auditable;
import az.bron.business.feature.company.domain.model.Company;
import az.bron.business.feature.master.domain.model.Master;
import az.bron.business.feature.master.domain.service.MasterService;
import az.bron.business.feature.masterprovidedservice.domain.model.MasterProvidedService;
import az.bron.business.feature.providedservice.application.model.request.Duration;
import az.bron.business.feature.servicecategory.domain.model.ServiceCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "services")
public class ProvidedService extends Auditable<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    private Duration duration;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private ServiceCategory category;

    @Transient
    private List<MasterProvidedService> masterServices;
}
