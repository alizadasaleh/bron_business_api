package az.bron.business.feature.appointment.domain.model;

import az.bron.business.feature.providedservice.domain.model.ProvidedService;
import az.bron.business.feature.staff.domain.model.Staff;
import az.bron.business.feature.user.domain.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private Double price;

    @ManyToOne
    @JoinColumn(name = "provided_service_id")
    private ProvidedService providedService;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

}
