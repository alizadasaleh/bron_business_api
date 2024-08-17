package az.bron.business.feature.company.presentation.controller;

import az.bron.business.feature.company.application.facade.CompanyFacade;
import az.bron.business.feature.company.application.model.request.CreateCompanyRequest;
import az.bron.business.feature.company.application.model.request.UpdateCompanyRequest;
import az.bron.business.feature.company.application.model.response.CreateCompanyResponse;
import az.bron.business.feature.company.application.model.response.GetCompanyResponse;
import az.bron.business.feature.company.application.model.response.UpdateCompanyResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/companies")
@RequiredArgsConstructor
public class CompanyRestController {
    private final CompanyFacade companyFacade;

    @PostMapping
    public ResponseEntity<CreateCompanyResponse> create(@Valid @RequestBody CreateCompanyRequest request) {
        var response = companyFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateCompanyResponse> update(@PathVariable Long id, @Valid @RequestBody UpdateCompanyRequest request) {
        var response = companyFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Collection<GetCompanyResponse>> getAll() {
        var response = companyFacade.getAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCompanyResponse> get(@PathVariable Long id) {
        var response = companyFacade.get(id);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        companyFacade.delete(id);

        return ResponseEntity.noContent()
                .build();
    }
}
