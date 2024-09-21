package az.bron.business.feature.company.domain.model;

import az.bron.business.common.Auditable;
import az.bron.business.feature.company.domain.model.contact.Contact;
import az.bron.business.feature.master.domain.model.Master;
import az.bron.business.feature.providedservice.domain.model.ProvidedService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@BatchSize(size = 25)
@Table(name = "companies")
public class Company extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    private String logoImageUrl;
    private String profileImageUrl;
    private String backgroundImageUrl;


    @Embedded
    private Contact contact;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<Master> masters;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<ProvidedService> providedServices;
}
