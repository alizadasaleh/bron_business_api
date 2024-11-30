package az.bron.business.feature.review.application.model.response;

import az.bron.business.feature.appointment.application.model.response.GetAppointmentResponse;
import lombok.Data;

@Data
public class CreateReviewResponse {
    private Long id;
    private String review;
    private GetAppointmentResponse appointment;
    private Float rating;
}
