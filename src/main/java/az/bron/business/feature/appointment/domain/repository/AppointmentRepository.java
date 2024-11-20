package az.bron.business.feature.appointment.domain.repository;

import az.bron.business.feature.appointment.domain.model.Appointment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
