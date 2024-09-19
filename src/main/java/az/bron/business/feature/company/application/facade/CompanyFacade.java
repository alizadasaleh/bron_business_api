package az.bron.business.feature.company.application.facade;

import az.bron.business.feature.company.application.model.request.CreateCompanyRequest;
import az.bron.business.feature.company.application.model.request.UpdateCompanyRequest;
import az.bron.business.feature.company.application.model.response.CreateCompanyResponse;
import az.bron.business.feature.company.application.model.response.GetCompanyResponse;
import az.bron.business.feature.company.application.model.response.UpdateCompanyResponse;

import java.util.List;

public interface CompanyFacade {
    CreateCompanyResponse create(CreateCompanyRequest request);

    UpdateCompanyResponse update(Long id, UpdateCompanyRequest request);

    GetCompanyResponse get(Long id, boolean withDetails);

    List<GetCompanyResponse> getAll(boolean withDetails);

    void delete(Long id);
}
