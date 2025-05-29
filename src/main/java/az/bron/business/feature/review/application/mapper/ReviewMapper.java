package az.bron.business.feature.review.application.mapper;

import az.bron.business.feature.review.application.model.request.CreateReviewRequest;
import az.bron.business.feature.review.application.model.request.UpdateReviewRequest;
import az.bron.business.feature.review.application.model.response.CreateReviewResponse;
import az.bron.business.feature.review.application.model.response.GetReviewResponse;
import az.bron.business.feature.review.application.model.response.UpdateReviewResponse;
import az.bron.business.feature.review.domain.model.Review;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    Review toModel(CreateReviewRequest request);

    Review toModel(UpdateReviewRequest request);

    CreateReviewResponse toCreateResponse(Review review);

    UpdateReviewResponse toUpdateResponse(Review review);

    GetReviewResponse toGetResponse(Review review);
}
