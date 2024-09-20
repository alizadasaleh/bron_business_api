package az.bron.business.feature.company.presentation.controller;

import az.bron.business.feature.company.application.facade.CompanyFacade;
import az.bron.business.feature.company.application.model.request.CreateCompanyRequest;
import az.bron.business.feature.company.application.model.request.UpdateCompanyRequest;
import az.bron.business.feature.company.application.model.response.CreateCompanyResponse;
import az.bron.business.feature.company.application.model.response.GetCompanyResponse;
import az.bron.business.feature.company.application.model.response.UpdateCompanyResponse;
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
@RequestMapping("api/v1/companies")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@SecurityRequirement(name = "bearerAuth")
public class CompanyRestController {
    private final CompanyFacade companyFacade;

    @GetMapping
    public ResponseEntity<List<GetCompanyResponse>> getCompany(@RequestParam boolean withDetails) {
        var response = companyFacade.getAll(withDetails);

        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<GetCompanyResponse> get(@PathVariable("id") Long id, @RequestParam boolean withDetails) {
        var response = companyFacade.get(id,withDetails);

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
    @PostMapping(path = "/{id}/profileImage/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> uploadProfileImage(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) throws IOException {

        try {
            companyFacade.uploadProfileImage(id, file);
            return ResponseEntity.ok("Profile image uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload profile image");
        }

    }

    @PostMapping(path = "/{id}/logoImage/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> uploadLogoImage(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) throws IOException {

        try {
            companyFacade.uploadLogoImage(id, file);
            return ResponseEntity.ok("Profile image uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload profile image");
        }

    }

    @PostMapping(path = "/{id}/backgroundImage/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> uploadBackgroundImage(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) throws IOException {

        try {
            companyFacade.uploadBackgroundImage(id, file);
            return ResponseEntity.ok("Profile image uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload profile image");
        }

    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
       companyFacade.delete(id);
    }
}
