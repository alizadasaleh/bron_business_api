package az.bron.business.feature.schedule.companyschedule.application.facade.impl;

import az.bron.business.feature.company.application.exception.CompanyNotFoundException;
import az.bron.business.feature.company.domain.model.Company;
import az.bron.business.feature.company.domain.service.CompanyService;
import az.bron.business.feature.schedule.companyschedule.application.facade.CompanyScheduleFacade;
import az.bron.business.feature.schedule.companyschedule.application.mapper.CompanyScheduleMapper;
import az.bron.business.feature.schedule.companyschedule.application.model.request.CreateCompanyScheduleRequest;
import az.bron.business.feature.schedule.companyschedule.application.model.request.UpdateCompanyScheduleRequest;
import az.bron.business.feature.schedule.companyschedule.application.model.response.CreateCompanyScheduleResponse;
import az.bron.business.feature.schedule.companyschedule.application.model.response.GetCompanyScheduleResponse;
import az.bron.business.feature.schedule.companyschedule.application.model.response.UpdateCompanyScheduleResponse;
import az.bron.business.feature.schedule.companyschedule.domain.model.CompanySchedule;
import az.bron.business.feature.schedule.companyschedule.domain.service.CompanyScheduleService;
import com.sun.jdi.InternalException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class CompanyScheduleFacadeImpl implements CompanyScheduleFacade {
    private final CompanyScheduleService companyScheduleService;
    private final CompanyService companyService;
    private final CompanyScheduleMapper companyScheduleMapper;

    @Override
    public CreateCompanyScheduleResponse create(CreateCompanyScheduleRequest request) {
        CompanySchedule companyScheduleModel = companyScheduleMapper.toModel(request);
        Company company = this.companyService.get(companyScheduleModel.getCompany().getId())
                .orElseThrow(CompanyNotFoundException::new);
        companyScheduleModel.setCompany(company);
        var companySchedule = companyScheduleService.create(companyScheduleModel);
        return companyScheduleMapper.toCreateResponse(companySchedule);
    }

    @Override
    public UpdateCompanyScheduleResponse update(Long id, UpdateCompanyScheduleRequest request) {
        var companyScheduleModel = companyScheduleMapper.toModel(request);

        var existingCompanySchedule = companyScheduleService.get(id);

        if (existingCompanySchedule.isEmpty()) {
            throw new InternalException("CompanySchedule with id " + id + " does not exist");
        }

        companyScheduleModel.setId(id);

        var companySchedule = companyScheduleService.create(companyScheduleModel);

        return companyScheduleMapper.toUpdateResponse(companySchedule);
    }

    @Override
    public GetCompanyScheduleResponse get(Long id) {
        var existingCompanySchedule = companyScheduleService.get(id);

        if (existingCompanySchedule.isEmpty()) {
            throw new InternalException("CompanySchedule with id " + id + " does not exist");
        }

        var companySchedule = existingCompanySchedule.get();

        return companyScheduleMapper.toGetResponse(companySchedule);
    }

    @Override
    public List<GetCompanyScheduleResponse> getAll() {
        var result = companyScheduleService.getAll();

        return result.stream()
                .map(companyScheduleMapper::toGetResponse)
                .toList();
    }

    @Override
    public void delete(Long id) {
        var existingCompanySchedule = companyScheduleService.get(id);

        if (existingCompanySchedule.isEmpty()) {
            throw new InternalException("CompanySchedule with id " + id + " does not exist");
        }

        companyScheduleService.delete(id);
    }
}
