package az.bron.business.feature.schedule.staffschedule.domain.model;

import az.bron.business.feature.schedule.common.models.Schedule;
import az.bron.business.feature.staff.domain.model.Staff;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "StaffSchedules")
public class StaffSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "json")
    @JdbcTypeCode(SqlTypes.JSON)
    private Schedule schedule;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id")
    @JsonIgnore
    private Staff staff;
}
