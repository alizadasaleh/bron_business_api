package az.bron.business.feature.company.domain.service.impl;

import az.bron.business.common.application.model.request.SortDirection;
import az.bron.business.feature.company.application.model.request.CompanySearchFilter;
import az.bron.business.feature.company.application.model.request.SortCompanyBy;
import az.bron.business.feature.company.domain.model.Company;
import az.bron.business.feature.company.domain.model.CompanyWithDistance;
import az.bron.business.feature.company.domain.repository.CompanyRepository;
import az.bron.business.feature.company.domain.repository.CompanySearchRepository;
import az.bron.business.feature.company.domain.service.CompanyService;
import jakarta.transaction.Transactional;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.hibernate.search.engine.search.query.SearchResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanySearchRepository companySearchRepository;

    @Override
    public Company create(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company update(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Optional<Company> get(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Page<Company> getAll(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    @Override
    public Optional<Company> getWithDetails(Long id) {
        return companyRepository.getWithDetails(id);
    }

    @Override
    public void delete(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateProfileImageUrl(String fileName, Long id) {
        companyRepository.insertProfileImageUrl(fileName, id);

    }

    @Override
    @Transactional
    public void updateBackgroundImageUrl(String fileName, String directory, Long id) {
        companyRepository.insertBackgroundImageUrl(directory + fileName, id);

    }

    @Override
    @Transactional
    public void updateLogoImageUrl(String fileName, Long id) {
        companyRepository.insertLogoImageUrl(fileName, id);

    }

    @Override
    public SearchResult<CompanyWithDistance> search(CompanySearchFilter companySearchFilter, int page, int size, SortCompanyBy sortCompanyBy, SortDirection sortDir) {
        return companySearchRepository.searchCompanies(companySearchFilter, page, size, sortDir, sortCompanyBy);
    }

    @Override
    public Page<Company> getAllWithDetails(Pageable pageable) {
        return companyRepository.getAllWithDetails(pageable);
    }
}
