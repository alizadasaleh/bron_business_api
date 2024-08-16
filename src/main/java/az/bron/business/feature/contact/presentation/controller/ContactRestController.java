package az.bron.business.feature.contact.presentation.controller;

import az.bron.business.feature.contact.application.facade.ContactFacade;
import az.bron.business.feature.contact.application.model.request.CreateContactRequest;
import az.bron.business.feature.contact.application.model.request.UpdateContactRequest;
import az.bron.business.feature.contact.application.model.response.CreateContactResponse;
import az.bron.business.feature.contact.application.model.response.GetContactResponse;
import az.bron.business.feature.contact.application.model.response.UpdateContactResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/contacts")
@RequiredArgsConstructor
public class ContactRestController {
    private final ContactFacade contactFacade;

    @PostMapping
    public ResponseEntity<CreateContactResponse> create(@Valid @RequestBody CreateContactRequest request) {
        var response = contactFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateContactResponse> update(@PathVariable Long id, @Valid @RequestBody UpdateContactRequest request) {
        var response = contactFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Collection<GetContactResponse>> getAll() {
        var response = contactFacade.getAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetContactResponse> get(@PathVariable Long id) {
        var response = contactFacade.get(id);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contactFacade.delete(id);

        return ResponseEntity.noContent()
                .build();
    }
}
