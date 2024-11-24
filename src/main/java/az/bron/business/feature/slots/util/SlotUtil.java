package az.bron.business.feature.slots.util;

import az.bron.business.feature.appointment.domain.service.AppointmentService;
import az.bron.business.feature.providedservice.domain.model.Duration;
import az.bron.business.feature.schedule.common.models.BreakHours;
import az.bron.business.feature.schedule.common.models.WorkingHours;
import az.bron.business.feature.slots.application.model.Slot;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SlotUtil {
    private AppointmentService appointmentService;

    public List<Slot> generateAvailableSlots(WorkingHours workingHours, LocalDate date, Duration duration,
                                             Long staffId) {
        List<Slot> slots = new ArrayList<>();
        LocalTime currentTime = workingHours.getStartTime();

        while (currentTime.isBefore(workingHours.getEndTime())) {
            LocalTime endTime = currentTime.plusMinutes(duration.getMinutes()).plusHours(duration.getHours());
            if (isSlotAvailable(currentTime, endTime, workingHours, date, staffId)) {
                slots.add(Slot.builder().startTime(currentTime).build());
            }
            currentTime = currentTime.plusMinutes(30); // Increment slot time by 30 minutes
        }

        return slots;
    }

    private boolean isSlotAvailable(LocalTime startTime, LocalTime endTime, WorkingHours workingHours, LocalDate date, Long staffId) {
        return !overlapsWithBreak(startTime, endTime, workingHours.getBreaks()) &&
                !appointmentService.checkIfOverlaps(startTime.atDate(date), endTime.atDate(date), staffId);
    }

    private boolean overlapsWithBreak(LocalTime startTime, LocalTime endTime, List<BreakHours> breaks) {
        return breaks.stream().anyMatch(breakHours ->
                startTime.isBefore(breakHours.getBreakEndTime()) && endTime.isAfter(breakHours.getBreakStartTime()));
    }

}
