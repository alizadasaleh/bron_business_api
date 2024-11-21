package az.bron.business.feature.schedule.companyschedule.domain.service;

import az.bron.business.feature.schedule.companyschedule.domain.model.CompanySchedule;

import java.util.List;
import java.util.Optional;

public interface CompanyScheduleService {
    CompanySchedule create(CompanySchedule companyschedule);

    CompanySchedule update(CompanySchedule companyschedule);

    Optional<CompanySchedule> get(Long id);

    List<CompanySchedule> getAll();

    void delete(Long id);

    Optional<CompanySchedule> getByCompanyId(Long companyId);
}
