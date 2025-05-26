package az.bron.business.feature.company.domain.model;

import az.bron.business.common.Auditable;
import az.bron.business.feature.company.domain.model.address.Address;
import az.bron.business.feature.company.domain.model.contact.Contact;
import az.bron.business.feature.providedservice.domain.model.Gender;
import az.bron.business.feature.providedservice.domain.model.ProvidedService;
import az.bron.business.feature.staff.domain.model.Staff;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@BatchSize(size = 25)
@Table(name = "companies")
@Indexed
public class Company extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @FullTextField
    private String name;

    @FullTextField
    private String description;

    private String logoImageUrl;
    private String profileImageUrl;
    private String backgroundImageUrl;

    @IndexedEmbedded(includePaths = {
            "location.latitude", "location.longitude",
    })
    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Embedded
    private Contact contact;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<Staff> staffs;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<ProvidedService> providedServices;
}
