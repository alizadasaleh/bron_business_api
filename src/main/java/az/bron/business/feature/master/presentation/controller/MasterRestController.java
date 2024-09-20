package az.bron.business.feature.master.presentation.controller;

import az.bron.business.feature.master.application.facade.MasterFacade;
import az.bron.business.feature.master.application.model.request.CreateMasterRequest;
import az.bron.business.feature.master.application.model.request.UpdateMasterRequest;
import az.bron.business.feature.master.application.model.response.CreateMasterResponse;
import az.bron.business.feature.master.application.model.response.GetMasterResponse;
import az.bron.business.feature.master.application.model.response.UpdateMasterResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/masters")
@SecurityRequirement(name = "bearerAuth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MasterRestController {
    private final MasterFacade masterFacade;

    @GetMapping
    public ResponseEntity<List<GetMasterResponse>> getMaster() {
        List<GetMasterResponse> response = masterFacade.getAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetMasterResponse> get(@PathVariable("id") Long id) {
        GetMasterResponse response = masterFacade.get(id);

        return ResponseEntity.ok(response);
    }
    @PostMapping(path = "/{id}/profileImage/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> uploadFile(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) throws IOException {

        try {
            masterFacade.uploadProfileImage(id, file);
            return ResponseEntity.ok("Profile image uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload profile image");
        }

    }

    @PostMapping
    public ResponseEntity<CreateMasterResponse> create(@RequestBody CreateMasterRequest request) {
        CreateMasterResponse response = masterFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateMasterResponse> update(@PathVariable("id") Long id, @RequestBody UpdateMasterRequest request) {
        UpdateMasterResponse response = masterFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
       masterFacade.delete(id);
    }
}
