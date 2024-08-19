package az.bron.business.feature.company.application.facade.impl;

import az.bron.business.feature.company.application.facade.CompanyFacade;
import az.bron.business.feature.company.application.mapper.CompanyMapper;
import az.bron.business.feature.company.application.model.request.CreateCompanyRequest;
import az.bron.business.feature.company.application.model.request.UpdateCompanyRequest;
import az.bron.business.feature.company.application.model.response.CreateCompanyResponse;
import az.bron.business.feature.company.application.model.response.GetCompanyResponse;
import az.bron.business.feature.company.application.model.response.UpdateCompanyResponse;
import az.bron.business.feature.company.domain.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class CompanyFacadeImpl implements CompanyFacade {
    private final CompanyService companyService;
    private final CompanyMapper companyMapper;

    @Override
    public CreateCompanyResponse create(CreateCompanyRequest request) {
        var companyModel = companyMapper.toModel(request);
        var company = companyService.create(companyModel);

        return companyMapper.toCreateResponse(company);
    }

    @Override
    public UpdateCompanyResponse update(Long id, UpdateCompanyRequest request) {
        var companyModel = companyMapper.toModel(request);

        var existingCompany = companyService.get(id);

        if (existingCompany.isEmpty()) {
            throw new RuntimeException("Company with id " + id + " does not exist");
        }

       companyModel.setId(id);

        var company = companyService.create(companyModel);

        return companyMapper.toUpdateResponse(company);
    }

    @Override
    public GetCompanyResponse get(Long id) {
        var existingCompany = companyService.get(id);

        if (existingCompany.isEmpty()) {
            throw new RuntimeException("Company with id " + id + " does not exist");
        }

        var company = existingCompany.get();

        return companyMapper.toGetResponse(company);
    }

    @Override
    public List<GetCompanyResponse> getAll() {
        var result = companyService.getAll();

        return result.stream()
                .map(companyMapper::toGetResponse)
                .toList();
    }

    @Override
    public void delete(Long id) {
        var existingCompany = companyService.get(id);

        if (existingCompany.isEmpty()) {
            throw new RuntimeException("Company with id " + id + " does not exist");
        }

       companyService.delete(id);
    }
}
