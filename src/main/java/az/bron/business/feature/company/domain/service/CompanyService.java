package az.bron.business.feature.company.domain.service;

import az.bron.business.feature.company.domain.model.Company;
import java.util.List;
import java.util.Optional;
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

    List<Company> search(String query);
}
