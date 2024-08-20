package az.bron.business.feature.address.presentation.controller;

import az.bron.business.feature.address.application.facade.AddressFacade;
import az.bron.business.feature.address.application.model.request.CreateAddressRequest;
import az.bron.business.feature.address.application.model.request.UpdateAddressRequest;
import az.bron.business.feature.address.application.model.response.CreateAddressResponse;
import az.bron.business.feature.address.application.model.response.GetAddressResponse;
import az.bron.business.feature.address.application.model.response.UpdateAddressResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/addresses")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AddressRestController {
    private final AddressFacade addressFacade;

    @GetMapping
    public ResponseEntity<List<GetAddressResponse>> getAddress() {
        var response = addressFacade.getAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetAddressResponse> get(@PathVariable("id") Long id) {
        var response = addressFacade.get(id);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateAddressResponse> create(@RequestBody CreateAddressRequest request) {
        var response = addressFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateAddressResponse> update(@PathVariable("id") Long id, @RequestBody UpdateAddressRequest request) {
        var response = addressFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
       addressFacade.delete(id);
    }
}
