package az.bron.business.feature.company.domain.model;

import az.bron.business.common.Auditable;
import az.bron.business.feature.contact.domain.model.Contact;
import az.bron.business.feature.master.domain.model.Master;
import az.bron.business.feature.providedservice.domain.model.ProvidedService;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "companies")
public class Company extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<Master> masters;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<ProvidedService> providedServices;
}
