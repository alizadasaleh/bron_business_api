package az.bron.business.feature.servicetype.presentation.controller;

import az.bron.business.feature.servicetype.application.facade.ServiceTypeFacade;
import az.bron.business.feature.servicetype.application.model.request.CreateServiceTypeRequest;
import az.bron.business.feature.servicetype.application.model.request.UpdateServiceTypeRequest;
import az.bron.business.feature.servicetype.application.model.response.CreateServiceTypeResponse;
import az.bron.business.feature.servicetype.application.model.response.GetServiceTypeResponse;
import az.bron.business.feature.servicetype.application.model.response.UpdateServiceTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/serviceTypes")
@RequiredArgsConstructor
public class ServiceTypeRestController {
    private final ServiceTypeFacade servicetypeFacade;

    @PostMapping
    public ResponseEntity<CreateServiceTypeResponse> create(@Valid @RequestBody CreateServiceTypeRequest request) {
        var response = servicetypeFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateServiceTypeResponse> update(@PathVariable Long id, @Valid @RequestBody UpdateServiceTypeRequest request) {
        var response = servicetypeFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Collection<GetServiceTypeResponse>> getAll() {
        var response = servicetypeFacade.getAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetServiceTypeResponse> get(@PathVariable Long id) {
        var response = servicetypeFacade.get(id);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        servicetypeFacade.delete(id);

        return ResponseEntity.noContent()
                .build();
    }
}
