package az.bron.business.feature.operatinghour.presentation.controller;

import az.bron.business.feature.operatinghour.application.facade.OperatinghourFacade;
import az.bron.business.feature.operatinghour.application.model.request.CreateOperatinghourRequest;
import az.bron.business.feature.operatinghour.application.model.request.UpdateOperatinghourRequest;
import az.bron.business.feature.operatinghour.application.model.response.CreateOperatinghourResponse;
import az.bron.business.feature.operatinghour.application.model.response.GetOperatinghourResponse;
import az.bron.business.feature.operatinghour.application.model.response.UpdateOperatinghourResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/operatinghours")
@RequiredArgsConstructor
public class OperatinghourRestController {
    private final OperatinghourFacade operatinghourFacade;

    @PostMapping
    public ResponseEntity<CreateOperatinghourResponse> create(@Valid @RequestBody CreateOperatinghourRequest request) {
        var response = operatinghourFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateOperatinghourResponse> update(@PathVariable Long id, @Valid @RequestBody UpdateOperatinghourRequest request) {
        var response = operatinghourFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Collection<GetOperatinghourResponse>> getAll() {
        var response = operatinghourFacade.getAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetOperatinghourResponse> get(@PathVariable Long id) {
        var response = operatinghourFacade.get(id);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        operatinghourFacade.delete(id);

        return ResponseEntity.noContent()
                .build();
    }
}
