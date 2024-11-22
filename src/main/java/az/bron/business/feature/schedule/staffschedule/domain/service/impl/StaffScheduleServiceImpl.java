package az.bron.business.feature.schedule.staffschedule.domain.service.impl;

import az.bron.business.feature.schedule.staffschedule.domain.model.StaffSchedule;
import az.bron.business.feature.schedule.staffschedule.domain.repository.StaffScheduleRepository;
import az.bron.business.feature.schedule.staffschedule.domain.service.StaffScheduleService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StaffScheduleServiceImpl implements StaffScheduleService {
    private final StaffScheduleRepository staffscheduleRepository;

    @Override
    public StaffSchedule create(StaffSchedule staffschedule) {
        return staffscheduleRepository.save(staffschedule);
    }

    @Override
    public StaffSchedule update(StaffSchedule staffschedule) {
        return staffscheduleRepository.save(staffschedule);
    }

    @Override
    public Optional<StaffSchedule> get(Long id) {
        return staffscheduleRepository.findById(id);
    }

    @Override
    public List<StaffSchedule> getAll() {
        return staffscheduleRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        staffscheduleRepository.deleteById(id);
    }

    @Override
    public Optional<StaffSchedule> getByStaffId(Long id) {
        return staffscheduleRepository.getStaffScheduleByStaff_Id(id);
    }

}
