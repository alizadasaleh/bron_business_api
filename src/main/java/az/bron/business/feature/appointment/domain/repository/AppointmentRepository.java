package az.bron.business.feature.appointment.domain.repository;

import az.bron.business.feature.appointment.domain.model.Appointment;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query("""
                SELECT CASE WHEN COUNT(a) > 0 THEN TRUE ELSE FALSE END
                FROM Appointment a
                WHERE a.staff.id = :staffId
                  AND a.endTime > :startTime
                  AND a.startTime < :endTime
            """)
    boolean checkIfOverlaps(LocalDateTime startTime, LocalDateTime endTime, Long staffId);


    List<Appointment> findAllByUserId(Long userId);
}
