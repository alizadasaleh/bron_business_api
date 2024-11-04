package az.bron.business.feature.schedule.companyschedule.application.facade;

import az.bron.business.feature.schedule.companyschedule.application.model.request.CreateCompanyScheduleRequest;
import az.bron.business.feature.schedule.companyschedule.application.model.request.UpdateCompanyScheduleRequest;
import az.bron.business.feature.schedule.companyschedule.application.model.response.CreateCompanyScheduleResponse;
import az.bron.business.feature.schedule.companyschedule.application.model.response.GetCompanyScheduleResponse;
import az.bron.business.feature.schedule.companyschedule.application.model.response.UpdateCompanyScheduleResponse;

import java.util.List;

public interface CompanyScheduleFacade {
    CreateCompanyScheduleResponse create(CreateCompanyScheduleRequest request);

    UpdateCompanyScheduleResponse update(Long id, UpdateCompanyScheduleRequest request);

    GetCompanyScheduleResponse get(Long id);

    List<GetCompanyScheduleResponse> getAll();

    void delete(Long id);
}
