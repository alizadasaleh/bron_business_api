package az.bron.business.feature.review.domain.service.impl;

import az.bron.business.feature.review.domain.model.Review;
import az.bron.business.feature.review.domain.repository.ReviewRepository;
import az.bron.business.feature.review.domain.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Override
    public Review create(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review update(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Optional<Review> get(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    @Override
    public void delete(Long id) {
       reviewRepository.deleteById(id);
    }
}
