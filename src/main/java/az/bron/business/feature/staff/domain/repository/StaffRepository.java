package az.bron.business.feature.staff.domain.repository;

import az.bron.business.feature.staff.domain.model.Staff;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
//    List<Staff> findAllByCompanyId(Long companyId);

    @Modifying
    @Query("UPDATE Staff m SET m.profileImageUrl = :fileName WHERE m.id = :id")
    void insertProfileImageUrl(String fileName, Long id);
}
