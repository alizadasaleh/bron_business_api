package az.bron.business.feature.appointment.domain.model;

import az.bron.business.feature.providedservice.domain.model.Duration;
import az.bron.business.feature.providedservice.domain.model.ProvidedService;
import az.bron.business.feature.staff.domain.model.Staff;
import az.bron.business.feature.staffprovidedservice.domain.model.StaffProvidedService;
import az.bron.business.feature.user.domain.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "provided_service_id")
    private ProvidedService providedService;
    
    private LocalDateTime startTime;
    private LocalDateTime endTime;

}
