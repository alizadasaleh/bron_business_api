package az.bron.business.feature.master.domain.repository;

import az.bron.business.feature.master.domain.model.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MasterRepository extends JpaRepository<Master, Long> {
    List<Master> findAllByCompanyId(Long companyId);

    @Modifying
    @Query("UPDATE Master m SET m.profileImageUrl = :fileName WHERE m.id = :id")
    void insertProfileImageUrl(String fileName, Long id);
}
