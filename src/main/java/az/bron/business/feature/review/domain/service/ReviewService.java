package az.bron.business.feature.review.domain.service;

import az.bron.business.feature.review.domain.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Review create(Review review);

    Review update(Review review);

    Optional<Review> get(Long id);

    List<Review> getAll();

    void delete(Long id);

    Optional<Review> getReviewByAppointmentIdAndUserId(Long appointmentId, Long userId);
}
