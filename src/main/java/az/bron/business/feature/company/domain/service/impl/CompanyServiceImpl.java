package az.bron.business.feature.company.domain.service.impl;

import az.bron.business.feature.company.domain.model.Company;
import az.bron.business.feature.company.domain.repository.CompanyRepository;
import az.bron.business.feature.company.domain.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

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
    public List<Company> getAll() {
        return companyRepository.findAll();
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
    public List<Company> getAllWithDetails() {
        return companyRepository.getAllWithDetails();
    }
}
