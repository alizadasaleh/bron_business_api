package az.bron.business.feature.company.application.facade;

import az.bron.business.feature.company.application.model.request.CreateCompanyRequest;
import az.bron.business.feature.company.application.model.request.UpdateCompanyRequest;
import az.bron.business.feature.company.application.model.response.CreateCompanyResponse;
import az.bron.business.feature.company.application.model.response.GetCompanyResponse;
import az.bron.business.feature.company.application.model.response.UpdateCompanyResponse;

import java.util.List;

public interface CompanyFacade {
    CreateCompanyResponse create(CreateCompanyRequest dto);

    UpdateCompanyResponse update(Long id, UpdateCompanyRequest dto);

    List<GetCompanyResponse> getAll();

    GetCompanyResponse get(Long id);

    void delete(Long id);
}
