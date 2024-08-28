package az.bron.business.feature.master.domain.model;

import az.bron.business.common.Auditable;
import az.bron.business.feature.company.domain.model.Company;
import az.bron.business.feature.masterprovidedservice.domain.model.MasterProvidedService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "master", fetch = FetchType.LAZY)
    private List<MasterProvidedService> masterServices ;

}
