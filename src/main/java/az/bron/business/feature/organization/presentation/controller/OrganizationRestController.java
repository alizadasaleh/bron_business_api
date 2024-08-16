package az.bron.business.feature.organization.presentation.controller;

import az.bron.business.feature.organization.application.facade.OrganizationFacade;
import az.bron.business.feature.organization.application.model.request.CreateOrganizationRequest;
import az.bron.business.feature.organization.application.model.request.UpdateOrganizationRequest;
import az.bron.business.feature.organization.application.model.response.CreateOrganizationResponse;
import az.bron.business.feature.organization.application.model.response.GetOrganizationResponse;
import az.bron.business.feature.organization.application.model.response.UpdateOrganizationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/organizations")
@RequiredArgsConstructor
public class OrganizationRestController {
    private final OrganizationFacade organizationFacade;

    @PostMapping
    public ResponseEntity<CreateOrganizationResponse> create(@Valid @RequestBody CreateOrganizationRequest request) {
        var response = organizationFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateOrganizationResponse> update(@PathVariable Long id, @Valid @RequestBody UpdateOrganizationRequest request) {
        var response = organizationFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Collection<GetOrganizationResponse>> getAll() {
        var response = organizationFacade.getAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetOrganizationResponse> get(@PathVariable Long id) {
        var response = organizationFacade.get(id);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        organizationFacade.delete(id);

        return ResponseEntity.noContent()
                .build();
    }
}
