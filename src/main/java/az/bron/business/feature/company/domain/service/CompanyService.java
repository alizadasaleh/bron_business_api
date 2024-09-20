package az.bron.business.feature.company.domain.service;

import az.bron.business.feature.company.domain.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Company create(Company company);

    Company update(Company company);

    Optional<Company> get(Long id);

    List<Company> getAll();

    Optional<Company> getWithDetails(Long id);

    List<Company> getAllWithDetails();

    void delete(Long id);

    void updateProfileImageUrl(String fileName, Long id);

    void updateBackgroundImageUrl(String fileName, Long id);

    void updateLogoImageUrl(String fileName, Long id);
}
