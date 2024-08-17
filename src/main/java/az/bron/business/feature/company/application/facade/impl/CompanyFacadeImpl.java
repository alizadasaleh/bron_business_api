package az.bron.business.feature.company.application.facade.impl;

import az.bron.business.feature.company.application.exception.CompanyNotFoundException;
import az.bron.business.feature.company.application.facade.CompanyFacade;
import az.bron.business.feature.company.application.mapper.CompanyMapper;
import az.bron.business.feature.company.application.model.request.CreateCompanyRequest;
import az.bron.business.feature.company.application.model.request.UpdateCompanyRequest;
import az.bron.business.feature.company.application.model.response.CreateCompanyResponse;
import az.bron.business.feature.company.application.model.response.GetCompanyResponse;
import az.bron.business.feature.company.application.model.response.UpdateCompanyResponse;
import az.bron.business.feature.company.domain.model.Company;
import az.bron.business.feature.company.domain.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class CompanyFacadeImpl implements CompanyFacade {
    private final CompanyService companyService;

    private final CompanyMapper companyMapper;

    @Override
    public CreateCompanyResponse create(CreateCompanyRequest request) {
        Company company = companyMapper.toModel(request);
        companyService.add(company);

        return companyMapper.toCreateResponse(company);
    }

    @Override
    public UpdateCompanyResponse update(Long id, UpdateCompanyRequest request) {
        Company company = companyMapper.toModel(request);

        var existingCompany = companyService.get(id);

        if (existingCompany.isEmpty()) {
            throw new CompanyNotFoundException();
        }

        var companyId = existingCompany.get().getId();

        company.setId(companyId);

        companyService.update(company);

        return companyMapper.toUpdateResponse(company);
    }

    @Override
    public List<GetCompanyResponse> getAll() {
        Collection<Company> companys = companyService.getAll();

        return companys.stream()
                .map(companyMapper::toVehicleResponse)
                .toList();
    }

    @Override
    public GetCompanyResponse get(Long id) {
        var company = companyService.get(id);

        if (company.isEmpty()) {
            throw new CompanyNotFoundException();
        }

        return companyMapper.toVehicleResponse(company.get());
    }

    @Override
    public void delete(Long id) {
        companyService.delete(id);
    }
}
