package az.bron.business.feature.appointment.application.facade.validation;

import az.bron.business.feature.appointment.application.excpetion.AppointmentNotAvailableException;
import az.bron.business.feature.appointment.application.model.request.CreateAppointmentRequest;
import az.bron.business.feature.providedservice.application.exception.ProvidedServiceNotFoundException;
import az.bron.business.feature.providedservice.domain.model.ProvidedService;
import az.bron.business.feature.providedservice.domain.service.ProvidedServiceService;
import az.bron.business.feature.schedule.common.models.BreakHours;
import az.bron.business.feature.schedule.common.models.Schedule;
import az.bron.business.feature.schedule.common.models.Workday;
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
import org.springframework.stereotype.Component;

@Component
public class AppointmentValidator {

    private final ProvidedServiceService providedServiceService;
    private final StaffProvidedServiceService staffProvidedServiceService;
    private final StaffService staffService;
    private final StaffScheduleService staffScheduleService;
    private final CompanyScheduleService companyScheduleService;

    public AppointmentValidator(ProvidedServiceService providedServiceService,
                                StaffProvidedServiceService staffProvidedServiceService, StaffService staffService,
                                StaffScheduleService staffScheduleService,
                                CompanyScheduleService companyScheduleService) {
        this.providedServiceService = providedServiceService;
        this.staffProvidedServiceService = staffProvidedServiceService;
        this.staffService = staffService;
        this.staffScheduleService = staffScheduleService;
        this.companyScheduleService = companyScheduleService;
    }

    public void validate(CreateAppointmentRequest request) {
        ProvidedService service =
                providedServiceService.get(request.getProvidedServiceId()).orElseThrow(() -> new ProvidedServiceNotFoundException(request.getProvidedServiceId()));
        Staff staff = staffService.get(request.getStaffId()).orElseThrow(() -> new StaffNotFoundException(request.getStaffId()));

        StaffProvidedService staffProvidedService  =
                staffProvidedServiceService.getByStaffIdAndProvidedServiceId(request.getStaffId(),
                request.getProvidedServiceId()).orElseThrow(StaffProvidedServiceNotFoundException::new);
        Schedule schedule = staffScheduleService.getByStaffId(request.getStaffId())
                .map(StaffSchedule::getSchedule)
                .orElseGet(() -> companyScheduleService.getByCompanyId(staff.getCompany().getId())
                        .map(CompanySchedule::getSchedule)
                        .orElseThrow(CompanyScheduleNotFoundException::new
                        ));

        DayOfWeek dayOfWeek = request.getStartTime().getDayOfWeek();
        WorkingHours workingHours = schedule.getSchedule().get(dayOfWeek);

        if(schedule.getSchedule().get(dayOfWeek) == null){
            throw new AppointmentNotAvailableException(dayOfWeek);
        }
        if (request.getStartTime().toLocalTime().isBefore(workingHours.getStartTime()) ||
                request.getStartTime().toLocalTime().isAfter(workingHours.getEndTime())) {
            throw new AppointmentNotAvailableException("Start time is outside working hours.");
        }
        LocalDateTime endTime =
                request.getStartTime().plusHours(service.getDuration().getHours()).plusMinutes(service.getDuration().getMinutes());

        if (endTime.toLocalTime().isAfter(workingHours.getEndTime())) {
            throw new AppointmentNotAvailableException("End time is outside working hours.");
        }

        for (BreakHours breakHours : workingHours.getBreaks()) {
            if (!request.getStartTime().toLocalTime().isBefore(breakHours.getBreakStartTime()) &&
                    !endTime.toLocalTime().isAfter(breakHours.getBreakEndTime())) {
                throw new AppointmentNotAvailableException("Appointment overlaps with a break time.");
            }
        }





    }
}
