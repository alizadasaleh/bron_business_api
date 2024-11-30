package az.bron.business.feature.review.domain.repository;

import az.bron.business.feature.review.domain.model.Review;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<Review> getByAppointmentIdAndUserId(Long appointmentId, Long userId);
}
