package az.bron.business.feature.review.application.facade.impl;

import az.bron.business.feature.appointment.application.excpetion.AppointmentNotFound;
import az.bron.business.feature.appointment.domain.model.Appointment;
import az.bron.business.feature.appointment.domain.service.AppointmentService;
import az.bron.business.feature.review.application.excpetion.ReviewAlreadyExistsException;
import az.bron.business.feature.review.application.excpetion.ReviewNotFoundException;
import az.bron.business.feature.review.application.excpetion.UnauthorizedReviewManipulationException;
import az.bron.business.feature.review.application.facade.ReviewFacade;
import az.bron.business.feature.review.application.mapper.ReviewMapper;
import az.bron.business.feature.review.application.model.request.CreateReviewRequest;
import az.bron.business.feature.review.application.model.request.UpdateReviewRequest;
import az.bron.business.feature.review.application.model.response.CreateReviewResponse;
import az.bron.business.feature.review.application.model.response.GetReviewResponse;
import az.bron.business.feature.review.application.model.response.UpdateReviewResponse;
import az.bron.business.feature.review.domain.service.ReviewService;
import az.bron.business.feature.user.application.model.request.AuthenticationService;
import az.bron.business.feature.user.domain.model.User;
import java.util.Objects;
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
    private final AuthenticationService authenticationService;
    private final AppointmentService appointmentService;

    @Override
    public CreateReviewResponse create(CreateReviewRequest request) {
        var reviewModel = reviewMapper.toModel(request);

        Long appointmentId = request.getAppointmentId();
        Appointment appointment = appointmentService.get(appointmentId).orElseThrow(() -> new AppointmentNotFound(appointmentId));
        User user = authenticationService.getCurrentUser();
        reviewService.getReviewByAppointmentIdAndUserId(appointmentId,user.getId()).orElseThrow(
                ReviewAlreadyExistsException::new);

        if(!Objects.equals(user.getId(), appointment.getUser().getId())) {
            throw new UnauthorizedReviewManipulationException(user.getId(),appointmentId);
        }
        reviewModel.setUser(user);
        reviewModel.setAppointment(appointment);

        var review = reviewService.create(reviewModel);

        return reviewMapper.toCreateResponse(review);
    }

    @Override
    public UpdateReviewResponse update(Long id, UpdateReviewRequest request) {
        var reviewModel = reviewMapper.toModel(request);

        var existingReview = reviewService.get(id);

        if (existingReview.isEmpty()) {
            throw new ReviewNotFoundException("Review with id " + id + " does not exist");
        }

       reviewModel.setId(id);


        var review = reviewService.create(reviewModel);

        return reviewMapper.toUpdateResponse(review);
    }

    @Override
    public GetReviewResponse get(Long id) {
        var existingReview = reviewService.get(id);

        if (existingReview.isEmpty()) {
            throw new ReviewNotFoundException("Review with id " + id + " does not exist");
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
            throw new ReviewNotFoundException("Review with id " + id + " does not exist");
        }

       reviewService.delete(id);
    }
}
