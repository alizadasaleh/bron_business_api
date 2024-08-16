package az.bron.business.feature.providedservice.presentation.controller;

import az.bron.business.feature.providedservice.application.facade.ProvidedserviceFacade;
import az.bron.business.feature.providedservice.application.model.request.CreateProvidedserviceRequest;
import az.bron.business.feature.providedservice.application.model.request.UpdateProvidedserviceRequest;
import az.bron.business.feature.providedservice.application.model.response.CreateProvidedserviceResponse;
import az.bron.business.feature.providedservice.application.model.response.GetProvidedserviceResponse;
import az.bron.business.feature.providedservice.application.model.response.UpdateProvidedserviceResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/providedservices")
@RequiredArgsConstructor
public class ProvidedserviceRestController {
    private final ProvidedserviceFacade providedserviceFacade;

    @PostMapping
    public ResponseEntity<CreateProvidedserviceResponse> create(@Valid @RequestBody CreateProvidedserviceRequest request) {
        var response = providedserviceFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateProvidedserviceResponse> update(@PathVariable Long id, @Valid @RequestBody UpdateProvidedserviceRequest request) {
        var response = providedserviceFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Collection<GetProvidedserviceResponse>> getAll() {
        var response = providedserviceFacade.getAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetProvidedserviceResponse> get(@PathVariable Long id) {
        var response = providedserviceFacade.get(id);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        providedserviceFacade.delete(id);

        return ResponseEntity.noContent()
                .build();
    }
}
