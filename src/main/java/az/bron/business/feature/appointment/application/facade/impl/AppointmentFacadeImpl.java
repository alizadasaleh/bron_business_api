package az.bron.business.feature.appointment.application.facade.impl;

import az.bron.business.feature.appointment.application.excpetion.AppointmentNotAvailableException;
import az.bron.business.feature.appointment.application.excpetion.AppointmentNotFount;
import az.bron.business.feature.appointment.application.facade.AppointmentFacade;
import az.bron.business.feature.appointment.application.mapper.AppointmentMapper;
import az.bron.business.feature.appointment.application.model.request.CreateAppointmentRequest;
import az.bron.business.feature.appointment.application.model.request.UpdateAppointmentRequest;
import az.bron.business.feature.appointment.application.model.response.CreateAppointmentResponse;
import az.bron.business.feature.appointment.application.model.response.GetAppointmentResponse;
import az.bron.business.feature.appointment.application.model.response.UpdateAppointmentResponse;
import az.bron.business.feature.appointment.domain.model.Appointment;
import az.bron.business.feature.appointment.domain.service.AppointmentService;
import az.bron.business.feature.providedservice.application.exception.ProvidedServiceNotFoundException;
import az.bron.business.feature.providedservice.domain.model.ProvidedService;
import az.bron.business.feature.providedservice.domain.service.ProvidedServiceService;
import az.bron.business.feature.schedule.common.models.BreakHours;
import az.bron.business.feature.schedule.common.models.Schedule;
import az.bron.business.feature.schedule.common.models.WorkingHours;
import az.bron.business.feature.schedule.companyschedule.application.exception.CompanyScheduleNotFoundException;
import az.bron.business.feature.schedule.companyschedule.domain.model.CompanySchedule;
import az.bron.business.feature.schedule.companyschedule.domain.service.CompanyScheduleService;
import az.bron.business.feature.schedule.staffschedule.domain.model.StaffSchedule;
import az.bron.business.feature.schedule.staffschedule.domain.service.StaffScheduleService;
import az.bron.business.feature.staff.application.exception.StaffNotFoundException;
import az.bron.business.feature.staff.domain.model.Staff;
import az.bron.business.feature.staff.domain.service.StaffService;
import az.bron.business.feature.staffprovidedservice.application.exception.StaffProvidedServiceNotFoundException;
import az.bron.business.feature.staffprovidedservice.domain.model.StaffProvidedService;
import az.bron.business.feature.staffprovidedservice.domain.service.StaffProvidedServiceService;
import az.bron.business.feature.user.application.model.request.AuthenticationService;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class AppointmentFacadeImpl implements AppointmentFacade {
    private final AppointmentService appointmentService;
    private final AppointmentMapper appointmentMapper;
    private final AuthenticationService authenticationService;
    private final ProvidedServiceService providedServiceService;
    private final StaffProvidedServiceService staffProvidedServiceService;
    private final StaffService staffService;
    private final StaffScheduleService staffScheduleService;
    private final CompanyScheduleService companyScheduleService;

    @Override
    public CreateAppointmentResponse create(CreateAppointmentRequest request) {
        Appointment appointmentModel = appointmentMapper.toModel(request);

        LocalDateTime startTime = request.getStartTime();
        Long staffId = request.getStaffId();
        Long serviceId = request.getProvidedServiceId();

        ProvidedService service = providedServiceService.get(serviceId)
                .orElseThrow(() -> new ProvidedServiceNotFoundException(serviceId));

        Staff staff = staffService.get(staffId)
                .orElseThrow(() -> new StaffNotFoundException(staffId));

        StaffProvidedService staffProvidedService =
                staffProvidedServiceService.getByStaffIdAndProvidedServiceId(staffId, serviceId)
                        .orElseThrow(StaffProvidedServiceNotFoundException::new);

        Schedule schedule = staffScheduleService.getByStaffId(staff.getId())
                .map(StaffSchedule::getSchedule)
                .orElse(null);

        if (schedule == null) {
            schedule = companyScheduleService.getByCompanyId(staff.getCompany().getId())
                    .map(CompanySchedule::getSchedule)
                    .orElseThrow(CompanyScheduleNotFoundException::new);
        }

        validateWorkingHours(startTime, schedule, service);
        validateBreakHours(startTime, schedule, service);
        validateOverlappingAppointments(startTime, service,staffId);

        appointmentModel.setEndTime(startTime.plusHours(service.getDuration().getHours()).plusMinutes(service.getDuration().getMinutes()));

//        appointmentModel.setUser(authenticationService.getCurrentUser());


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


    private void validateWorkingHours(LocalDateTime startTime, Schedule schedule, ProvidedService service) {
        DayOfWeek dayOfWeek = startTime.getDayOfWeek();
        WorkingHours workingHours = schedule.getSchedule().get(dayOfWeek);

        if (workingHours == null) {
            throw new AppointmentNotAvailableException(dayOfWeek);
        }

        LocalTime localTime = startTime.toLocalTime();
        LocalDateTime endTime = startTime.plusHours(service.getDuration().getHours())
                .plusMinutes(service.getDuration().getMinutes());

        if (localTime.isBefore(workingHours.getStartTime()) || localTime.isAfter(workingHours.getEndTime())) {
            throw new AppointmentNotAvailableException("Start time is outside working hours.");
        }

        if (endTime.toLocalTime().isAfter(workingHours.getEndTime())) {
            throw new AppointmentNotAvailableException("End time is outside working hours.");
        }
    }


    private void validateBreakHours(LocalDateTime startTime, Schedule schedule, ProvidedService service) {
        DayOfWeek dayOfWeek = startTime.getDayOfWeek();
        WorkingHours workingHours = schedule.getSchedule().get(dayOfWeek);
        LocalDateTime endTime = startTime.plusHours(service.getDuration().getHours())
                .plusMinutes(service.getDuration().getMinutes());

        if (workingHours != null) {
            for (BreakHours breakHours : workingHours.getBreaks()) {
                if (startTime.toLocalTime().isBefore(breakHours.getBreakEndTime()) &&
                        endTime.toLocalTime().isAfter(breakHours.getBreakStartTime())) {
                    throw new AppointmentNotAvailableException("Appointment overlaps with break hours.");
                }
            }
        }
    }

    private void validateOverlappingAppointments(LocalDateTime startTime, ProvidedService service, Long staffId) {
        LocalDateTime endTime = startTime.plusHours(service.getDuration().getHours())
                .plusMinutes(service.getDuration().getMinutes());

        if (appointmentService.checkIfOverlaps(startTime, endTime, staffId)) {
            throw new AppointmentNotAvailableException("Appointment overlaps with an appointment.");
        }
    }

}
