package az.bron.business.feature.review.application.facade.impl;

import az.bron.business.exception.ResourceNotFoundException;
import az.bron.business.feature.review.application.facade.ReviewFacade;
import az.bron.business.feature.review.application.mapper.ReviewMapper;
import az.bron.business.feature.review.application.model.request.CreateReviewRequest;
import az.bron.business.feature.review.application.model.request.UpdateReviewRequest;
import az.bron.business.feature.review.application.model.response.CreateReviewResponse;
import az.bron.business.feature.review.application.model.response.GetReviewResponse;
import az.bron.business.feature.review.application.model.response.UpdateReviewResponse;
import az.bron.business.feature.review.domain.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ReviewFacadeImpl implements ReviewFacade {
    private final ReviewService reviewService;
    private final ReviewMapper reviewMapper;

    @Override
    public CreateReviewResponse create(CreateReviewRequest request) {
        var reviewModel = reviewMapper.toModel(request);
        var review = reviewService.create(reviewModel);

        return reviewMapper.toCreateResponse(review);
    }

    @Override
    public UpdateReviewResponse update(Long id, UpdateReviewRequest request) {
        var reviewModel = reviewMapper.toModel(request);

        var existingReview = reviewService.get(id);

        if (existingReview.isEmpty()) {
            throw new ResourceNotFoundException("Review with id " + id + " does not exist");
        }

       reviewModel.setId(id);

        var review = reviewService.create(reviewModel);

        return reviewMapper.toUpdateResponse(review);
    }

    @Override
    public GetReviewResponse get(Long id) {
        var existingReview = reviewService.get(id);

        if (existingReview.isEmpty()) {
            throw new ResourceNotFoundException("Review with id " + id + " does not exist");
        }

        var review = existingReview.get();

        return reviewMapper.toGetResponse(review);
    }

    @Override
    public List<GetReviewResponse> getAll() {
        var result = reviewService.getAll();

        return result.stream()
                .map(reviewMapper::toGetResponse)
                .toList();
    }

    @Override
    public void delete(Long id) {
        var existingReview = reviewService.get(id);

        if (existingReview.isEmpty()) {
            throw new ResourceNotFoundException("Review with id " + id + " does not exist");
        }

       reviewService.delete(id);
    }
}
