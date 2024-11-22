package az.bron.business.feature.schedule.companyschedule.domain.service.impl;

import az.bron.business.feature.schedule.companyschedule.domain.model.CompanySchedule;
import az.bron.business.feature.schedule.companyschedule.domain.repository.CompanyScheduleRepository;
import az.bron.business.feature.schedule.companyschedule.domain.service.CompanyScheduleService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyScheduleServiceImpl implements CompanyScheduleService {
    private final CompanyScheduleRepository companyScheduleRepository;

    @Override
    public CompanySchedule create(CompanySchedule companyschedule) {
        return companyScheduleRepository.save(companyschedule);
    }

    @Override
    public CompanySchedule update(CompanySchedule companyschedule) {
        return companyScheduleRepository.save(companyschedule);
    }

    @Override
    public Optional<CompanySchedule> get(Long id) {
        return companyScheduleRepository.findById(id);
    }

    @Override
    public List<CompanySchedule> getAll() {
        return companyScheduleRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        companyScheduleRepository.deleteById(id);
    }

    @Override
    public Optional<CompanySchedule> getByCompanyId(Long companyId) {
        return companyScheduleRepository.getByCompany_Id(companyId);
    }
}
