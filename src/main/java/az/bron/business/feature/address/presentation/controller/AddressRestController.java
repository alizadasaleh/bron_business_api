package az.bron.business.feature.address.presentation.controller;

import az.bron.business.feature.address.application.facade.AddressFacade;
import az.bron.business.feature.address.application.model.request.CreateAddressRequest;
import az.bron.business.feature.address.application.model.request.UpdateAddressRequest;
import az.bron.business.feature.address.application.model.response.CreateAddressResponse;
import az.bron.business.feature.address.application.model.response.GetAddressResponse;
import az.bron.business.feature.address.application.model.response.UpdateAddressResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/addresses")
@RequiredArgsConstructor
public class AddressRestController {
    private final AddressFacade addressFacade;

    @PostMapping
    public ResponseEntity<CreateAddressResponse> create(@Valid @RequestBody CreateAddressRequest request) {
        var response = addressFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateAddressResponse> update(@PathVariable Long id, @Valid @RequestBody UpdateAddressRequest request) {
        var response = addressFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Collection<GetAddressResponse>> getAll() {
        var response = addressFacade.getAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetAddressResponse> get(@PathVariable Long id) {
        var response = addressFacade.get(id);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        addressFacade.delete(id);

        return ResponseEntity.noContent()
                .build();
    }
}
