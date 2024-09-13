package az.bron.business.feature.company.domain.model;

import az.bron.business.common.Auditable;
import az.bron.business.feature.company.domain.model.contact.Contact;
import az.bron.business.feature.master.domain.model.Master;
import az.bron.business.feature.providedservice.domain.model.ProvidedService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@BatchSize(size=25)
@Table(name = "companies")
public class Company extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;


    @Embedded
    private Contact contact;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<Master> masters;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<ProvidedService> providedServices;
}
