package az.bron.business.feature.servicecategory.domain.repository;

import az.bron.business.feature.servicecategory.domain.model.ServiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory, Integer> {
    @Modifying
    @Query("UPDATE ServiceCategory s SET s.coverImageUrl = :fileName WHERE s.id = :id")
    void insertCoverImageUrl(String fileName, Long id);
}
