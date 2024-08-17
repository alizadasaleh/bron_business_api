package az.bron.business.feature.company.domain.service.impl;

import az.bron.business.feature.company.domain.model.Company;
import az.bron.business.feature.company.domain.repository.CompanyRepository;
import az.bron.business.feature.company.domain.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    final CompanyRepository companyRepository;

    @Override
    public void add(Company company) {
        companyRepository.add(company);
    }

    @Override
    public void update(Company company) {
        companyRepository.update(company);
    }

    @Override
    public void delete(Long id) {
        companyRepository.delete(id);
    }

    @Override
    public Optional<Company> get(Long id) {
        return companyRepository.get(id);
    }

    @Override
    public Collection<Company> getAll() {
        return companyRepository.getAll();
    }
}

