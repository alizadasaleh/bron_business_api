package az.bron.business.feature.master.domain.model;

import az.bron.business.common.Auditable;
import az.bron.business.feature.company.domain.model.Company;
import az.bron.business.feature.masterprovidedservice.domain.model.MasterProvidedService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
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
@Table(name = "masters")
public class Master extends Auditable<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String profileImageUrl;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    @OneToMany(mappedBy = "master", fetch = FetchType.LAZY)
    private List<MasterProvidedService> masterServices;


}
