package az.bron.business.feature.review.presentation.controller;

import az.bron.business.feature.review.application.facade.ReviewFacade;
import az.bron.business.feature.review.application.model.request.CreateReviewRequest;
import az.bron.business.feature.review.application.model.request.UpdateReviewRequest;
import az.bron.business.feature.review.application.model.response.CreateReviewResponse;
import az.bron.business.feature.review.application.model.response.GetReviewResponse;
import az.bron.business.feature.review.application.model.response.UpdateReviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/Reviews")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReviewRestController {
    private final ReviewFacade reviewFacade;

    @GetMapping
    public ResponseEntity<List<GetReviewResponse>> getReview() {
        var response = reviewFacade.getAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetReviewResponse> get(@PathVariable("id") Long id) {
        var response = reviewFacade.get(id);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateReviewResponse> create(@RequestBody CreateReviewRequest request) {
        var response = reviewFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateReviewResponse> update(@PathVariable("id") Long id, @RequestBody UpdateReviewRequest request) {
        var response = reviewFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
       reviewFacade.delete(id);
    }
}
