package az.bron.business.feature.slots.application.facade;

import az.bron.business.feature.slots.application.model.Slot;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public interface SlotsFacade {
    List<Slot> getAvailableSlots(Long staffId, Long serviceId, LocalDate date);
}
