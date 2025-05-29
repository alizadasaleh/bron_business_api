package az.bron.business.feature.company.domain.service;

import az.bron.business.common.application.model.request.SortDirection;
import az.bron.business.feature.company.application.model.request.CompanySearchFilter;
import az.bron.business.feature.company.application.model.request.SearchSortCompanyBy;
import az.bron.business.feature.company.domain.model.Company;
import az.bron.business.feature.company.domain.model.CompanyWithDistance;
import java.util.Optional;

import org.hibernate.search.engine.search.query.SearchResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompanyService {
    Company create(Company company);

    Company update(Company company);

    Optional<Company> get(Long id);

    Page<Company> getAll(Pageable pageable);

    Optional<Company> getWithDetails(Long id);

    Page<Company> getAllWithDetails(Pageable pageable);

    void delete(Long id);

    void updateProfileImageUrl(String fileName, Long id);

    void updateBackgroundImageUrl(String fileName, String directory, Long id);

    void updateLogoImageUrl(String fileName, Long id);

    SearchResult<CompanyWithDistance> search(CompanySearchFilter companySearchFilter, int page, int size, SearchSortCompanyBy searchSortCompanyBy, SortDirection sortDir);
}
