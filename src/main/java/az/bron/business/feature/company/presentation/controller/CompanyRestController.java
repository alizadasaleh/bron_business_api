package az.bron.business.feature.company.presentation.controller;

import az.bron.business.feature.company.application.facade.CompanyFacade;
import az.bron.business.feature.company.application.model.request.CreateCompanyRequest;
import az.bron.business.feature.company.application.model.request.UpdateCompanyRequest;
import az.bron.business.feature.company.application.model.response.CreateCompanyResponse;
import az.bron.business.feature.company.application.model.response.GetCompanyResponse;
import az.bron.business.feature.company.application.model.response.UpdateCompanyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/companies")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CompanyRestController {
    private final CompanyFacade companyFacade;

    @GetMapping
    public ResponseEntity<List<GetCompanyResponse>> getCompany() {
        var response = companyFacade.getAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCompanyResponse> get(@PathVariable("id") Long id) {
        var response = companyFacade.get(id);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateCompanyResponse> create(@RequestBody CreateCompanyRequest request) {
        var response = companyFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateCompanyResponse> update(@PathVariable("id") Long id, @RequestBody UpdateCompanyRequest request) {
        var response = companyFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
       companyFacade.delete(id);
    }
}
