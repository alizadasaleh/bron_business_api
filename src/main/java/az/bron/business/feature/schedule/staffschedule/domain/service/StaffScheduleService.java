package az.bron.business.feature.schedule.staffschedule.domain.service;

import az.bron.business.feature.schedule.staffschedule.domain.model.StaffSchedule;

import java.util.List;
import java.util.Optional;

public interface StaffScheduleService {
    StaffSchedule create(StaffSchedule staffschedule);

    StaffSchedule update(StaffSchedule staffschedule);

    Optional<StaffSchedule> get(Long id);

    List<StaffSchedule> getAll();

    void delete(Long id);
}
