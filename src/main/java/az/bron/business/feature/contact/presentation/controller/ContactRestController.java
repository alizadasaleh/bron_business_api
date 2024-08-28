package az.bron.business.feature.contact.presentation.controller;

import az.bron.business.feature.contact.application.facade.ContactFacade;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import az.bron.business.feature.contact.application.model.request.CreateContactRequest;
import az.bron.business.feature.contact.application.model.request.UpdateContactRequest;
import az.bron.business.feature.contact.application.model.response.CreateContactResponse;
import az.bron.business.feature.contact.application.model.response.GetContactResponse;
import az.bron.business.feature.contact.application.model.response.UpdateContactResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/contacts")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@SecurityRequirement(name = "bearerAuth")
public class ContactRestController {
    private final ContactFacade contactFacade;

    @GetMapping
    public ResponseEntity<List<GetContactResponse>> getContact() {
        var response = contactFacade.getAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetContactResponse> get(@PathVariable("id") Long id) {
        var response = contactFacade.get(id);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateContactResponse> create(@RequestBody CreateContactRequest request) {
        var response = contactFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateContactResponse> update(@PathVariable("id") Long id, @RequestBody UpdateContactRequest request) {
        var response = contactFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
       contactFacade.delete(id);
    }
}
