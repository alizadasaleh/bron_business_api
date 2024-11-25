package az.bron.business.feature.slots.application.facade.impl;

import az.bron.business.feature.appointment.application.excpetion.AppointmentNotAvailableException;
import az.bron.business.feature.appointment.domain.service.AppointmentService;
import az.bron.business.feature.providedservice.domain.model.Duration;
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
import az.bron.business.feature.slots.application.facade.SlotsFacade;
import az.bron.business.feature.slots.application.model.Slot;
import az.bron.business.feature.slots.util.SlotUtil;
import az.bron.business.feature.staff.application.exception.StaffNotFoundException;
import az.bron.business.feature.staff.domain.model.Staff;
import az.bron.business.feature.staff.domain.service.StaffService;
import az.bron.business.feature.staffprovidedservice.application.exception.StaffProvidedServiceNotFoundException;
import az.bron.business.feature.staffprovidedservice.domain.model.StaffProvidedService;
import az.bron.business.feature.staffprovidedservice.domain.service.StaffProvidedServiceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class SlotsFacadeImpl implements SlotsFacade {

    private final StaffService staffService;
    private final ProvidedServiceService providedServiceService;
    private final StaffProvidedServiceService staffProvidedServiceService;
    private final StaffScheduleService staffScheduleService;
    private final CompanyScheduleService companyScheduleService;
    private SlotUtil slotUtil;

    @Override
    public List<Slot> getAvailableSlots(Long staffId, Long serviceId, LocalDate date) {
        Staff staff = staffService.get(staffId).orElseThrow(() -> new StaffNotFoundException("Staff not found: " + staffId));

        ProvidedService providedService = providedServiceService.get(serviceId).orElseThrow(() -> new StaffNotFoundException("Service not found: " + serviceId));

        StaffProvidedService staffProvidedService =
                staffProvidedServiceService.getByStaffIdAndProvidedServiceId(staffId, serviceId)
                .orElseThrow(() -> new StaffProvidedServiceNotFoundException("Staff is not assigned to the provided service."));



        Schedule schedule = staffScheduleService.getByStaffId(staff.getId())
                .map(StaffSchedule::getSchedule)
                .orElse(null);

        if (schedule == null) {
            schedule = companyScheduleService.getByCompanyId(staff.getCompany().getId())
                    .map(CompanySchedule::getSchedule)
                    .orElseThrow(CompanyScheduleNotFoundException::new);
        }


        WorkingHours workingHours = schedule.getSchedule().get(date.getDayOfWeek());
        if (workingHours == null) {
            throw new AppointmentNotAvailableException("No working hours available for: " + date.getDayOfWeek());
        }

        return slotUtil.generateAvailableSlots(workingHours, date, providedService.getDuration(), staffId);
    }


}
