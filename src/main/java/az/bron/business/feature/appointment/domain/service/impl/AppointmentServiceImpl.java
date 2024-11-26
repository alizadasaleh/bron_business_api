package az.bron.business.feature.appointment.domain.service.impl;

import az.bron.business.feature.appointment.domain.model.Appointment;
import az.bron.business.feature.appointment.domain.repository.AppointmentRepository;
import az.bron.business.feature.appointment.domain.service.AppointmentService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;

    @Override
    public Appointment create(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment update(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Optional<Appointment> get(Long id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public boolean checkIfOverlaps(LocalDateTime startTime, LocalDateTime endTime, Long staffId) {
        return appointmentRepository.checkIfOverlaps(startTime, endTime, staffId);
    }

    @Override
    public List<Appointment> findAllByUser(Long userId) {
        return appointmentRepository.findAllByUserId(userId);
    }

}
