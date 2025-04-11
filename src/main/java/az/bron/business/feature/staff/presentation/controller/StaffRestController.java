package az.bron.business.feature.staff.presentation.controller;

import az.bron.business.feature.staff.application.facade.StaffFacade;
import az.bron.business.feature.staff.application.model.request.CreateStaffRequest;
import az.bron.business.feature.staff.application.model.request.UpdateStaffRequest;
import az.bron.business.feature.staff.application.model.response.CreateStaffResponse;
import az.bron.business.feature.staff.application.model.response.GetStaffResponse;
import az.bron.business.feature.staff.application.model.response.UpdateStaffResponse;
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
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping("api/v1/staffs")
@SecurityRequirement(name = "bearerAuth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StaffRestController {
    private final StaffFacade staffFacade;

    @GetMapping
    public ResponseEntity<List<GetStaffResponse>> getStaff(@ModelAttribute StaffFilter filter) {
        List<GetStaffResponse> response = staffFacade.getAll(filter);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetStaffResponse> get(@PathVariable("id") Long id) {
        GetStaffResponse response = staffFacade.get(id);

        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/{id}/profileImage/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> uploadFile(@PathVariable("id") Long id,
                                             @RequestParam("file") MultipartFile file) throws IOException {

        try {
            staffFacade.uploadProfileImage(id, file);
            return ResponseEntity.ok("Profile image uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload profile image");
        }

    }

    @PostMapping
    public ResponseEntity<CreateStaffResponse> create(@RequestBody CreateStaffRequest request) {
        CreateStaffResponse response = staffFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateStaffResponse> update(@PathVariable("id") Long id,
                                                      @RequestBody UpdateStaffRequest request) {
        UpdateStaffResponse response = staffFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        staffFacade.delete(id);
    }
}
