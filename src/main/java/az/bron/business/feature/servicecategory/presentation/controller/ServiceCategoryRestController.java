package az.bron.business.feature.servicecategory.presentation.controller;

import az.bron.business.feature.servicecategory.application.facade.ServiceCategoryFacade;
import az.bron.business.feature.servicecategory.application.model.request.CreateServiceCategoryRequest;
import az.bron.business.feature.servicecategory.application.model.request.UpdateServiceCategoryRequest;
import az.bron.business.feature.servicecategory.application.model.response.CreateServiceCategoryResponse;
import az.bron.business.feature.servicecategory.application.model.response.GetServiceCategoryResponse;
import az.bron.business.feature.servicecategory.application.model.response.UpdateServiceCategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/ServiceCategories")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ServiceCategoryRestController {
    private final ServiceCategoryFacade servicecategoryFacade;

    @GetMapping
    public ResponseEntity<List<GetServiceCategoryResponse>> getServiceCategory() {
        var response = servicecategoryFacade.getAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetServiceCategoryResponse> get(@PathVariable("id") Integer id) {
        var response = servicecategoryFacade.get(id);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateServiceCategoryResponse> create(@RequestBody CreateServiceCategoryRequest request) {
        var response = servicecategoryFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateServiceCategoryResponse> update(@PathVariable("id") Integer id, @RequestBody UpdateServiceCategoryRequest request) {
        var response = servicecategoryFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
       servicecategoryFacade.delete(id);
    }
}
