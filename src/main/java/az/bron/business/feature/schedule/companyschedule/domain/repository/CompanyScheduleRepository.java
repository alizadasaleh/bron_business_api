package az.bron.business.feature.schedule.companyschedule.domain.repository;

import az.bron.business.feature.schedule.companyschedule.domain.model.CompanySchedule;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyScheduleRepository extends JpaRepository<CompanySchedule, Long> {

    CompanySchedule findByCompanyId(Long companyId);

    Optional<CompanySchedule> getByCompany_Id(Long companyId);
}
