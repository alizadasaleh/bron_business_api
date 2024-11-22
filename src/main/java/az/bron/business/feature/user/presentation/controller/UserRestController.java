package az.bron.business.feature.user.presentation.controller;

import az.bron.business.feature.user.application.facade.UserFacade;
import az.bron.business.feature.user.application.model.request.CreateUserRequest;
import az.bron.business.feature.user.application.model.request.UpdateUserRequest;
import az.bron.business.feature.user.application.model.response.CreateUserResponse;
import az.bron.business.feature.user.application.model.response.GetUserResponse;
import az.bron.business.feature.user.application.model.response.UpdateUserResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/admins")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@SecurityRequirement(name = "bearerAuth")
public class UserRestController {
    private final UserFacade userFacade;

    @GetMapping
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<List<GetUserResponse>> getUser() {
        var response = userFacade.getAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<GetUserResponse> get(@PathVariable("id") Long id) {
        var response = userFacade.get(id);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<CreateUserResponse> create(@RequestBody CreateUserRequest request) {
        var response = userFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<UpdateUserResponse> update(@PathVariable("id") Long id,
                                                     @RequestBody UpdateUserRequest request) {
        var response = userFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public void delete(@PathVariable("id") Long id) {
        userFacade.delete(id);
    }
}
