package az.bron.business.feature.master.presentation.controller;

import az.bron.business.feature.master.application.facade.MasterFacade;
import az.bron.business.feature.master.application.model.request.CreateMasterRequest;
import az.bron.business.feature.master.application.model.request.UpdateMasterRequest;
import az.bron.business.feature.master.application.model.response.CreateMasterResponse;
import az.bron.business.feature.master.application.model.response.GetMasterResponse;
import az.bron.business.feature.master.application.model.response.UpdateMasterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/masters")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MasterRestController {
    private final MasterFacade masterFacade;

    @GetMapping
    public ResponseEntity<List<GetMasterResponse>> getMaster() {
        var response = masterFacade.getAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetMasterResponse> get(@PathVariable("id") Long id) {
        var response = masterFacade.get(id);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateMasterResponse> create(@RequestBody CreateMasterRequest request) {
        var response = masterFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateMasterResponse> update(@PathVariable("id") Long id, @RequestBody UpdateMasterRequest request) {
        var response = masterFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
       masterFacade.delete(id);
    }
}
