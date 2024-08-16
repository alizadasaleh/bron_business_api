package az.bron.business.feature.businessowner.presentation.controller;

import az.bron.business.feature.businessowner.application.facade.BusinessownerFacade;
import az.bron.business.feature.businessowner.application.model.request.CreateBusinessownerRequest;
import az.bron.business.feature.businessowner.application.model.request.UpdateBusinessownerRequest;
import az.bron.business.feature.businessowner.application.model.response.CreateBusinessownerResponse;
import az.bron.business.feature.businessowner.application.model.response.GetBusinessownerResponse;
import az.bron.business.feature.businessowner.application.model.response.UpdateBusinessownerResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/businessowners")
@RequiredArgsConstructor
public class BusinessownerRestController {
    private final BusinessownerFacade businessownerFacade;

    @PostMapping
    public ResponseEntity<CreateBusinessownerResponse> create(@Valid @RequestBody CreateBusinessownerRequest request) {
        var response = businessownerFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateBusinessownerResponse> update(@PathVariable Long id, @Valid @RequestBody UpdateBusinessownerRequest request) {
        var response = businessownerFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Collection<GetBusinessownerResponse>> getAll() {
        var response = businessownerFacade.getAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetBusinessownerResponse> get(@PathVariable Long id) {
        var response = businessownerFacade.get(id);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        businessownerFacade.delete(id);

        return ResponseEntity.noContent()
                .build();
    }
}
