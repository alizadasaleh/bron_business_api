package az.bron.business.feature.masterprovidedservice.presentation.controller;

import az.bron.business.feature.masterprovidedservice.application.facade.MasterProvidedServiceFacade;
import az.bron.business.feature.masterprovidedservice.application.model.request.CreateMasterProvidedServiceRequest;
import az.bron.business.feature.masterprovidedservice.application.model.request.UpdateMasterProvidedServiceRequest;
import az.bron.business.feature.masterprovidedservice.application.model.response.CreateMasterProvidedServiceResponse;
import az.bron.business.feature.masterprovidedservice.application.model.response.GetMasterProvidedServiceResponse;
import az.bron.business.feature.masterprovidedservice.application.model.response.UpdateMasterProvidedServiceResponse;
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
@RequestMapping("api/v1/masterprovidedservices")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@SecurityRequirement(name = "bearerAuth")
public class MasterProvidedServiceRestController {
    private final MasterProvidedServiceFacade masterprovidedserviceFacade;

    @GetMapping
    public ResponseEntity<List<GetMasterProvidedServiceResponse>> getMasterProvidedService() {
        var response = masterprovidedserviceFacade.getAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetMasterProvidedServiceResponse> get(@PathVariable("id") Long id) {
        var response = masterprovidedserviceFacade.get(id);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateMasterProvidedServiceResponse> create(
            @RequestBody CreateMasterProvidedServiceRequest request) {
        var response = masterprovidedserviceFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateMasterProvidedServiceResponse> update(@PathVariable("id") Long id,
                                                                      @RequestBody UpdateMasterProvidedServiceRequest request) {
        var response = masterprovidedserviceFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/{id}/coverImage/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> uploadCoverImage(@PathVariable("id") Long id,
                                                   @RequestParam("file") MultipartFile file) throws IOException {

        try {
            masterprovidedserviceFacade.uploadCoverImage(id, file);
            return ResponseEntity.ok("Profile image uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload profile image");
        }

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        masterprovidedserviceFacade.delete(id);
    }
}
