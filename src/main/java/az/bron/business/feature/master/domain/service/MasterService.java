package az.bron.business.feature.master.domain.service;

import az.bron.business.feature.master.domain.model.Master;
import java.util.List;
import java.util.Optional;

public interface MasterService {
    Master create(Master master);

    Master update(Master master);

    Optional<Master> get(Long id);

    List<Master> getAll();

    List<Master> getAllByCompanyId(Long companyId);

    void delete(Long id);

    void updateProfileImageUrl(String fileName, Long id);
}
