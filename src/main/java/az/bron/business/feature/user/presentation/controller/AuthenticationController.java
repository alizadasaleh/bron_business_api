package az.bron.business.feature.user.presentation.controller;

import az.bron.business.feature.user.application.facade.AuthenticationFacade;
import az.bron.business.feature.user.application.model.request.LoginUserRequest;
import az.bron.business.feature.user.application.model.request.RegisterUserRequest;
import az.bron.business.feature.user.application.model.response.GetUserResponse;
import az.bron.business.feature.user.application.model.response.LoginResponse;
import az.bron.business.feature.user.application.model.response.RegisterUserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationFacade authenticationFacade;

    public AuthenticationController(AuthenticationFacade authenticationFacade) {
        this.authenticationFacade = authenticationFacade;
    }

    @PostMapping("/signup")
    public ResponseEntity<RegisterUserResponse> register(@RequestBody RegisterUserRequest registerUserRequest) {
        RegisterUserResponse registeredUser = authenticationFacade.register(registerUserRequest);

        return ResponseEntity.ok(registeredUser);
    }

    @RequestMapping(value = "/confirm-account", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<String> confirmUserAccount(@RequestParam("token") String confirmationToken) {
        return ResponseEntity.ok(authenticationFacade.confirmEmail(confirmationToken));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserRequest loginUserDto) {
        LoginResponse authenticatedUser = authenticationFacade.login(loginUserDto);

        return ResponseEntity.ok(authenticatedUser);
    }

    @GetMapping("/me")
    public ResponseEntity<GetUserResponse> authenticatedUser() {
        return ResponseEntity.ok(authenticationFacade.getCurrentUser());
    }
}
