package az.bron.business.feature.providedservice.domain.model;

import az.bron.business.common.Auditable;
import az.bron.business.feature.company.domain.model.Company;
import az.bron.business.feature.staffprovidedservice.domain.model.StaffProvidedService;
import az.bron.business.feature.servicecategory.domain.model.ServiceCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private ServiceCategory category;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String coverImageUrl;

    @OneToMany(mappedBy = "providedService", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<StaffProvidedService> staffServices;
}
