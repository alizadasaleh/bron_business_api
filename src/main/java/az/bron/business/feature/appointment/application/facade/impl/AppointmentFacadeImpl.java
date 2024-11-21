package az.bron.business.feature.appointment.application.facade.impl;

import az.bron.business.feature.appointment.application.excpetion.AppointmentNotFount;
import az.bron.business.feature.appointment.application.facade.AppointmentFacade;
import az.bron.business.feature.appointment.application.facade.validation.AppointmentValidator;
import az.bron.business.feature.appointment.application.mapper.AppointmentMapper;
import az.bron.business.feature.appointment.application.model.request.CreateAppointmentRequest;
import az.bron.business.feature.appointment.application.model.request.UpdateAppointmentRequest;
import az.bron.business.feature.appointment.application.model.response.CreateAppointmentResponse;
import az.bron.business.feature.appointment.application.model.response.GetAppointmentResponse;
import az.bron.business.feature.appointment.application.model.response.UpdateAppointmentResponse;
import az.bron.business.feature.appointment.domain.model.Appointment;
import az.bron.business.feature.appointment.domain.service.AppointmentService;
import az.bron.business.feature.user.application.model.request.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class AppointmentFacadeImpl implements AppointmentFacade {
    private final AppointmentService appointmentService;
    private final AppointmentMapper appointmentMapper;
    private final AuthenticationService authenticationService;
    private final AppointmentValidator appointmentValidator;

    @Override
    public CreateAppointmentResponse create(CreateAppointmentRequest request) {
        Appointment appointmentModel = appointmentMapper.toModel(request);

        appointmentValidator.validate(request);

        appointmentModel.setUser(authenticationService.getCurrentUser());

        Appointment appointment = appointmentService.create(appointmentModel);

        return appointmentMapper.toCreateResponse(appointment);
    }


    @Override
    public UpdateAppointmentResponse update(Long id, UpdateAppointmentRequest request) {
        var appointmentModel = appointmentMapper.toModel(request);

        var existingAppointment = appointmentService.get(id);

        if (existingAppointment.isEmpty()) {
            throw new AppointmentNotFount("Appointment with id " + id + " does not exist");
        }

       appointmentModel.setId(id);

        var appointment = appointmentService.create(appointmentModel);

        return appointmentMapper.toUpdateResponse(appointment);
    }

    @Override
    public GetAppointmentResponse get(Long id) {
        var existingAppointment = appointmentService.get(id);

        if (existingAppointment.isEmpty()) {
            throw new AppointmentNotFount("Appointment with id " + id + " does not exist");
        }

        var appointment = existingAppointment.get();

        return appointmentMapper.toGetResponse(appointment);
    }

    @Override
    public List<GetAppointmentResponse> getAll() {
        var result = appointmentService.getAll();

        return result.stream()
                .map(appointmentMapper::toGetResponse)
                .toList();
    }

    @Override
    public void delete(Long id) {
        var existingAppointment = appointmentService.get(id);

        if (existingAppointment.isEmpty()) {
            throw new AppointmentNotFount("Appointment with id " + id + " does not exist");
        }

       appointmentService.delete(id);
    }

}
