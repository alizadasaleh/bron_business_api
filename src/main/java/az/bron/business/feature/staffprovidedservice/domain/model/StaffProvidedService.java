package az.bron.business.feature.staffprovidedservice.domain.model;

import az.bron.business.feature.staff.domain.model.Staff;
import az.bron.business.feature.providedservice.domain.model.ProvidedService;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "staff_services")

public class StaffProvidedService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String coverImageUrl;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private ProvidedService providedService;

    private Double price;
}
