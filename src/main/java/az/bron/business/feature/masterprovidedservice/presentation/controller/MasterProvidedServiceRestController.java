package az.bron.business.feature.masterprovidedservice.presentation.controller;

import az.bron.business.feature.masterprovidedservice.application.facade.MasterProvidedServiceFacade;
import az.bron.business.feature.masterprovidedservice.application.model.request.CreateMasterProvidedServiceRequest;
import az.bron.business.feature.masterprovidedservice.application.model.request.UpdateMasterProvidedServiceRequest;
import az.bron.business.feature.masterprovidedservice.application.model.response.CreateMasterProvidedServiceResponse;
import az.bron.business.feature.masterprovidedservice.application.model.response.GetMasterProvidedServiceResponse;
import az.bron.business.feature.masterprovidedservice.application.model.response.UpdateMasterProvidedServiceResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<CreateMasterProvidedServiceResponse> create(@RequestBody CreateMasterProvidedServiceRequest request) {
        var response = masterprovidedserviceFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateMasterProvidedServiceResponse> update(@PathVariable("id") Long id, @RequestBody UpdateMasterProvidedServiceRequest request) {
        var response = masterprovidedserviceFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
       masterprovidedserviceFacade.delete(id);
    }
}
