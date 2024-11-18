package az.bron.business.feature.company.application.facade.impl;

import az.bron.business.common.application.model.request.SortDirection;
import az.bron.business.config.S3Service;
import az.bron.business.feature.company.application.exception.CompanyNotFoundException;
import az.bron.business.feature.company.application.facade.CompanyFacade;
import az.bron.business.feature.company.application.mapper.CompanyMapper;
import az.bron.business.feature.company.application.model.request.CreateCompanyRequest;
import az.bron.business.feature.company.application.model.request.SortCompanyBy;
import az.bron.business.feature.company.application.model.request.UpdateCompanyRequest;
import az.bron.business.feature.company.application.model.response.CompanySearchResponse;
import az.bron.business.feature.company.application.model.response.CreateCompanyResponse;
import az.bron.business.feature.company.application.model.response.GetCompanyResponse;
import az.bron.business.feature.company.application.model.response.UpdateCompanyResponse;
import az.bron.business.feature.company.domain.model.Company;
import az.bron.business.feature.company.domain.service.CompanyService;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Log4j2
@Service
@RequiredArgsConstructor
public class CompanyFacadeImpl implements CompanyFacade {
    private final CompanyService companyService;
    private final CompanyMapper companyMapper;
    private final S3Service s3Service;

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
            throw new CompanyNotFoundException("Company with id " + id + " does not exist");
        }

        companyModel.setId(id);

        var company = companyService.create(companyModel);

        return companyMapper.toUpdateResponse(company);
    }

    @Override
    public GetCompanyResponse get(Long id, boolean withDetails) {
        Optional<Company> existingCompany;

        if (withDetails) {
            existingCompany = companyService.getWithDetails(id);
        } else {
            existingCompany = companyService.get(id);
        }

        if (existingCompany.isEmpty()) {
            throw new CompanyNotFoundException("Company with id " + id + " does not exist");
        }

        Company company = existingCompany.get();


        if (withDetails) {
            return companyMapper.toGetWithDetailsResponse(company);
        } else {
            return companyMapper.toGetResponse(company);
        }
    }

    @Override
    public Page<?> getAll(boolean includeDetails, int pageNumber, int pageSize,
                          SortCompanyBy sortBy, SortDirection sortDirection) {
        Sort sort = sortDirection.toString().equalsIgnoreCase("asc") ?
                Sort.by(sortBy.toString()).ascending() :
                Sort.by(sortBy.toString()).descending();

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<Company> companyPage = includeDetails ?
                companyService.getAllWithDetails(pageable) :
                companyService.getAll(pageable);

        List<?> companyResponses = companyPage.stream()
                .map(company -> includeDetails ?
                        companyMapper.toGetWithDetailsResponse(company) :
                        companyMapper.toGetResponse(company))
                .toList();

        return new PageImpl<>(companyResponses, pageable, companyPage.getTotalElements());
    }


    @Override
    public void delete(Long id) {
        var existingCompany = companyService.get(id);

        if (existingCompany.isEmpty()) {
            throw new CompanyNotFoundException("Company with id " + id + " does not exist");
        }

        companyService.delete(id);
    }

    @Override
    public void uploadProfileImage(Long id, MultipartFile file) throws IOException {
        String fileName = String.valueOf(UUID.randomUUID());
        String url = s3Service.uploadFile(fileName, file, "company/image/profile/");
        companyService.updateProfileImageUrl(url, id);
    }

    @Override
    public void uploadLogoImage(Long id, MultipartFile file) throws IOException {
        String fileName = String.valueOf(UUID.randomUUID());
        String url = s3Service.uploadFile(fileName, file, "company/image/logo/");
        companyService.updateLogoImageUrl(url, id);
    }

    @Override
    public void uploadBackgroundImage(Long id, MultipartFile file) throws IOException {
        String fileName = String.valueOf(UUID.randomUUID());
        String directory = "company/image/background/";
        String url = s3Service.uploadFile(fileName, file, directory);
        companyService.updateBackgroundImageUrl(url, directory, id);
    }

    @Override
    public List<CompanySearchResponse> search(String query) {
        return companyMapper.toCompanySearchResponse(companyService.search(query));

    }
}
