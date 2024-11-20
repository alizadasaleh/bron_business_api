package az.bron.business.feature.schedule.staffschedule.domain.repository;

import az.bron.business.feature.schedule.staffschedule.domain.model.StaffSchedule;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffScheduleRepository extends JpaRepository<StaffSchedule, Long> {

    Optional<StaffSchedule> getStaffScheduleByStaff_Id(Long id);
}
