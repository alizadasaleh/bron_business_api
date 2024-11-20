package az.bron.business.feature.appointment.domain.service.impl;

import az.bron.business.feature.appointment.domain.model.Appointment;
import az.bron.business.feature.appointment.domain.repository.AppointmentRepository;
import az.bron.business.feature.appointment.domain.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

}
