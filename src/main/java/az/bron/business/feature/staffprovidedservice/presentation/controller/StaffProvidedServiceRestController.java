package az.bron.business.feature.staffprovidedservice.presentation.controller;

import az.bron.business.feature.staffprovidedservice.application.facade.StaffProvidedServiceFacade;
import az.bron.business.feature.staffprovidedservice.application.model.request.CreateStaffProvidedServiceRequest;
import az.bron.business.feature.staffprovidedservice.application.model.request.UpdateStaffProvidedServiceRequest;
import az.bron.business.feature.staffprovidedservice.application.model.response.CreateStaffProvidedServiceResponse;
import az.bron.business.feature.staffprovidedservice.application.model.response.GetStaffProvidedServiceResponse;
import az.bron.business.feature.staffprovidedservice.application.model.response.UpdateStaffProvidedServiceResponse;
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
@RequestMapping("api/v1/staffprovidedservices")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@SecurityRequirement(name = "bearerAuth")
public class StaffProvidedServiceRestController {
    private final StaffProvidedServiceFacade staffprovidedserviceFacade;

    @GetMapping
    public ResponseEntity<List<GetStaffProvidedServiceResponse>> getStaffProvidedService() {
        var response = staffprovidedserviceFacade.getAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetStaffProvidedServiceResponse> get(@PathVariable("id") Long id) {
        var response = staffprovidedserviceFacade.get(id);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateStaffProvidedServiceResponse> create(
            @RequestBody CreateStaffProvidedServiceRequest request) {
        var response = staffprovidedserviceFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateStaffProvidedServiceResponse> update(@PathVariable("id") Long id,
                                                                      @RequestBody UpdateStaffProvidedServiceRequest
                                                                              request) {
        var response = staffprovidedserviceFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/{id}/coverImage/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> uploadCoverImage(@PathVariable("id") Long id,
                                                   @RequestParam("file") MultipartFile file) throws IOException {

        try {
            staffprovidedserviceFacade.uploadCoverImage(id, file);
            return ResponseEntity.ok("Profile image uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload profile image");
        }

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        staffprovidedserviceFacade.delete(id);
    }
}
