package az.bron.business.feature.appointment.domain.service;

import az.bron.business.feature.appointment.domain.model.Appointment;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    Appointment create(Appointment appointment);

    Appointment update(Appointment appointment);

    Optional<Appointment> get(Long id);

    List<Appointment> getAll();

    void delete(Long id);

    boolean checkIfOverlaps(LocalDateTime startTime, LocalDateTime endTime, Long staffId);

    List<Appointment> findAllByUser(Long userId);
}
