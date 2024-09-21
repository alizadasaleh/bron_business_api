package az.bron.business.feature.providedservice.presentation.controller;

import az.bron.business.feature.providedservice.application.facade.ProvidedServiceFacade;
import az.bron.business.feature.providedservice.application.model.request.CreateProvidedServiceRequest;
import az.bron.business.feature.providedservice.application.model.request.UpdateProvidedServiceRequest;
import az.bron.business.feature.providedservice.application.model.response.CreateProvidedServiceResponse;
import az.bron.business.feature.providedservice.application.model.response.GetProvidedServiceResponse;
import az.bron.business.feature.providedservice.application.model.response.UpdateProvidedServiceResponse;
import az.bron.business.feature.providedservice.domain.repository.ProvidedServiceRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/providedServices")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@SecurityRequirement(name = "bearerAuth")
public class ProvidedServiceRestController {
    private final ProvidedServiceFacade providedserviceFacade;

    @GetMapping
    public ResponseEntity<List<GetProvidedServiceResponse>> getProvidedService() {
        var response = providedserviceFacade.getAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetProvidedServiceResponse> get(@PathVariable("id") Long id) {
        var response = providedserviceFacade.get(id);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateProvidedServiceResponse> create(@RequestBody CreateProvidedServiceRequest request) {
        var response = providedserviceFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateProvidedServiceResponse> update(@PathVariable("id") Long id, @RequestBody UpdateProvidedServiceRequest request) {
        var response = providedserviceFacade.update(id, request);

        return ResponseEntity.ok(response);
    }


    @PostMapping(path = "/{id}/coverImage/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> uploadCoverImage(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) throws IOException {

        try {
            providedserviceFacade.uploadCoverImage(id, file);
            return ResponseEntity.ok("Profile image uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload profile image");
        }

    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
       providedserviceFacade.delete(id);
    }
}
