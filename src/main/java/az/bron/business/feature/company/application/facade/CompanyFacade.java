package az.bron.business.feature.company.application.facade;

import az.bron.business.common.application.model.request.SortDirection;
import az.bron.business.feature.company.application.model.request.CompanySearchFilter;
import az.bron.business.feature.company.application.model.request.CreateCompanyRequest;
import az.bron.business.feature.company.application.model.request.SearchSortCompanyBy;
import az.bron.business.feature.company.application.model.request.SortCompanyBy;
import az.bron.business.feature.company.application.model.request.UpdateCompanyRequest;
import az.bron.business.feature.company.application.model.response.CompanySearchResponse;
import az.bron.business.feature.company.application.model.response.CreateCompanyResponse;
import az.bron.business.feature.company.application.model.response.GetCompanyResponse;
import az.bron.business.feature.company.application.model.response.UpdateCompanyResponse;
import java.io.IOException;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

public interface CompanyFacade {
    CreateCompanyResponse create(CreateCompanyRequest request);

    UpdateCompanyResponse update(Long id, UpdateCompanyRequest request);

    GetCompanyResponse get(Long id, boolean withDetails);

    Page<?> getAll(boolean withDetails, int page, int size, SortCompanyBy sortBy,
                   SortDirection sortDir);

    void delete(Long id);

    void uploadProfileImage(Long id, MultipartFile file) throws IOException;

    void uploadLogoImage(Long id, MultipartFile file) throws IOException;

    void uploadBackgroundImage(Long id, MultipartFile file) throws IOException;

    Page<CompanySearchResponse> search(CompanySearchFilter companySearchFilter, int page, int size, SearchSortCompanyBy searchSortCompanyBy, SortDirection sortDir);
}
