package az.bron.business.feature.company.presentation.controller;

import az.bron.business.common.application.model.request.SortDirection;
import az.bron.business.feature.company.application.facade.CompanyFacade;
import az.bron.business.feature.company.application.model.request.CompanySearchFilter;
import az.bron.business.feature.company.application.model.request.CreateCompanyRequest;
import az.bron.business.feature.company.application.model.request.SortCompanyBy;
import az.bron.business.feature.company.application.model.request.UpdateCompanyRequest;
import az.bron.business.feature.company.application.model.response.CompanySearchResponse;
import az.bron.business.feature.company.application.model.response.CreateCompanyResponse;
import az.bron.business.feature.company.application.model.response.GetCompanyResponse;
import az.bron.business.feature.company.application.model.response.UpdateCompanyResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/companies")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@SecurityRequirement(name = "bearerAuth")
public class CompanyRestController {
    private final CompanyFacade companyFacade;

    @GetMapping
    public ResponseEntity<Page<?>> getCompany(@RequestParam boolean withDetails,
                                              @RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "10") int size,
                                              @RequestParam(defaultValue = "Id") SortCompanyBy sortBy,
                                              @RequestParam(defaultValue = "ASC") SortDirection sortDir) {
        var response = companyFacade.getAll(withDetails, page, size, sortBy, sortDir);

        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<GetCompanyResponse> get(@PathVariable("id") Long id, @RequestParam boolean withDetails) {
        var response = companyFacade.get(id, withDetails);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateCompanyResponse> create(@RequestBody CreateCompanyRequest request) {
        var response = companyFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateCompanyResponse> update(@PathVariable("id") Long id,
                                                        @RequestBody UpdateCompanyRequest request) {
        var response = companyFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/{id}/profileImage/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> uploadProfileImage(@PathVariable("id") Long id,
                                                     @RequestParam("file") MultipartFile file) throws IOException {

        try {
            companyFacade.uploadProfileImage(id, file);
            return ResponseEntity.ok("Profile image uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload profile image");
        }

    }

    @PostMapping(path = "/{id}/logoImage/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> uploadLogoImage(@PathVariable("id") Long id,
                                                  @RequestParam("file") MultipartFile file) throws IOException {

        try {
            companyFacade.uploadLogoImage(id, file);
            return ResponseEntity.ok("Profile image uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload profile image");
        }

    }

    @PostMapping(path = "/{id}/backgroundImage/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> uploadBackgroundImage(@PathVariable("id") Long id,
                                                        @RequestParam("file") MultipartFile file) throws IOException {

        try {
            companyFacade.uploadBackgroundImage(id, file);
            return ResponseEntity.ok("Profile image uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload profile image");
        }

    }

    @GetMapping("/search")
    public ResponseEntity<Page<CompanySearchResponse>> search(@ModelAttribute CompanySearchFilter companySearchFilter,
                                                              @RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "10") int size,
                                                              @RequestParam SortCompanyBy sortCompanyBy,
                                                              @RequestParam SortDirection sortDir) {
        return ResponseEntity.ok(companyFacade.search(companySearchFilter, page, size, sortCompanyBy, sortDir));
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        companyFacade.delete(id);
    }
}
