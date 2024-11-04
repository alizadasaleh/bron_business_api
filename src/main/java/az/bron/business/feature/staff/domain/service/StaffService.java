package az.bron.business.feature.staff.domain.service;

import az.bron.business.feature.staff.domain.model.Staff;
import java.util.List;
import java.util.Optional;

public interface StaffService {
    Staff create(Staff staff);

    Staff update(Staff staff);

    Optional<Staff> get(Long id);

    List<Staff> getAll();

    List<Staff> getAllByCompanyId(Long companyId);

    void delete(Long id);

    void updateProfileImageUrl(String fileName, Long id);
}
