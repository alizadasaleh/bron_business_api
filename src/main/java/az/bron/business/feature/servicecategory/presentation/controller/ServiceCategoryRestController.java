package az.bron.business.feature.servicecategory.presentation.controller;

import az.bron.business.feature.servicecategory.application.facade.ServiceCategoryFacade;
import az.bron.business.feature.servicecategory.application.model.request.CreateServiceCategoryRequest;
import az.bron.business.feature.servicecategory.application.model.request.UpdateServiceCategoryRequest;
import az.bron.business.feature.servicecategory.application.model.response.CreateServiceCategoryResponse;
import az.bron.business.feature.servicecategory.application.model.response.GetServiceCategoryResponse;
import az.bron.business.feature.servicecategory.application.model.response.UpdateServiceCategoryResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/serviceCategories")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@SecurityRequirement(name = "bearerAuth")
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
    public ResponseEntity<UpdateServiceCategoryResponse> update(@PathVariable("id") Integer id,
                                                                @RequestBody UpdateServiceCategoryRequest request) {
        var response = servicecategoryFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/{id}/coverImage/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> uploadCoverImage(@PathVariable("id") Long id,
                                                   @RequestParam("file") MultipartFile file) throws IOException {

        try {
            servicecategoryFacade.uploadCoverImage(id, file);
            return ResponseEntity.ok("Cover image uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload profile image");
        }

    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        servicecategoryFacade.delete(id);
    }
}
