package az.bron.business.feature.providedservice.domain.model;

import az.bron.business.common.Auditable;
import az.bron.business.feature.company.domain.model.Company;
import az.bron.business.feature.masterprovidedservice.domain.model.MasterProvidedService;
import az.bron.business.feature.servicecategory.domain.model.ServiceCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.util.List;

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

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private ServiceCategory category;

    @OneToMany(mappedBy = "providedService", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<MasterProvidedService> masterServices;
}
