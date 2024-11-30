package az.bron.business.feature.review.application.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateReviewRequest {
    private String review;
    @NotNull
    private Long appointmentId;
    @ValidRating
    @NotNull
    private Float rating;
}
