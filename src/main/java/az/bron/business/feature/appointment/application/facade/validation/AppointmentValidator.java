package az.bron.business.feature.appointment.application.facade.validation;

import az.bron.business.feature.appointment.application.excpetion.AppointmentNotAvailableException;
import az.bron.business.feature.appointment.application.model.request.CreateAppointmentRequest;
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
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.springframework.stereotype.Component;

@Component
public class AppointmentValidator {

    private final ProvidedServiceService providedServiceService;
    private final StaffProvidedServiceService staffProvidedServiceService;
    private final StaffService staffService;
    private final StaffScheduleService staffScheduleService;
    private final CompanyScheduleService companyScheduleService;
    private final AppointmentService appointmentService;

    public AppointmentValidator(ProvidedServiceService providedServiceService,
                                StaffProvidedServiceService staffProvidedServiceService, StaffService staffService,
                                StaffScheduleService staffScheduleService,
                                CompanyScheduleService companyScheduleService, AppointmentService appointmentService) {
        this.providedServiceService = providedServiceService;
        this.staffProvidedServiceService = staffProvidedServiceService;
        this.staffService = staffService;
        this.staffScheduleService = staffScheduleService;
        this.companyScheduleService = companyScheduleService;
        this.appointmentService = appointmentService;
    }

    public void validate(CreateAppointmentRequest request) {

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


        validateWorkingHours(request, schedule, service);
        validateBreakHours(request, schedule, service);
        validateOverlappingAppointments(request, service);
    }


    private void validateWorkingHours(CreateAppointmentRequest request, Schedule schedule, ProvidedService service) {
        DayOfWeek dayOfWeek = request.getStartTime().getDayOfWeek();
        WorkingHours workingHours = schedule.getSchedule().get(dayOfWeek);

        if (workingHours == null) {
            throw new AppointmentNotAvailableException(dayOfWeek);
        }

        LocalTime startTime = request.getStartTime().toLocalTime();
        LocalDateTime endTime = calculateEndTime(request.getStartTime(), service);

        if (startTime.isBefore(workingHours.getStartTime()) || startTime.isAfter(workingHours.getEndTime())) {
            throw new AppointmentNotAvailableException("Start time is outside working hours.");
        }

        if (endTime.toLocalTime().isAfter(workingHours.getEndTime())) {
            throw new AppointmentNotAvailableException("End time is outside working hours.");
        }
    }

    private LocalDateTime calculateEndTime(LocalDateTime startTime, ProvidedService service) {
        return startTime.plusHours(service.getDuration().getHours())
                .plusMinutes(service.getDuration().getMinutes());
    }

    private void validateBreakHours(CreateAppointmentRequest request, Schedule schedule, ProvidedService service) {
        DayOfWeek dayOfWeek = request.getStartTime().getDayOfWeek();
        WorkingHours workingHours = schedule.getSchedule().get(dayOfWeek);

        if (workingHours != null) {
            LocalDateTime startTime = request.getStartTime();
            LocalDateTime endTime = calculateEndTime(startTime, service);

            for (BreakHours breakHours : workingHours.getBreaks()) {
                if (startTime.toLocalTime().isBefore(breakHours.getBreakEndTime()) &&
                        endTime.toLocalTime().isAfter(breakHours.getBreakStartTime())) {
                    throw new AppointmentNotAvailableException("Appointment overlaps with break hours.");
                }
            }
        }
    }

    private void validateOverlappingAppointments(CreateAppointmentRequest request, ProvidedService service) {
        LocalDateTime endTime = calculateEndTime(request.getStartTime(), service);

        if (appointmentService.checkIfOverlaps(request.getStartTime(), endTime, request.getStaffId())) {
            throw new AppointmentNotAvailableException("Appointment overlaps with an appointment.");
        }
    }
}
