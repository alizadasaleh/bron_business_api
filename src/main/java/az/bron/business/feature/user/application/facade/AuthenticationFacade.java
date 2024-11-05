package az.bron.business.feature.user.application.facade;


import az.bron.business.config.JwtService;
import az.bron.business.feature.role.domain.model.Role;
import az.bron.business.feature.role.domain.model.RoleEnum;
import az.bron.business.feature.role.domain.repository.RoleRepository;
import az.bron.business.feature.role.domain.service.RoleService;
import az.bron.business.feature.user.application.model.request.AuthenticationService;
import az.bron.business.feature.user.application.model.request.LoginUserRequest;
import az.bron.business.feature.user.application.model.request.RegisterUserRequest;
import az.bron.business.feature.user.application.model.response.GetUserResponse;
import az.bron.business.feature.user.application.model.response.LoginResponse;
import az.bron.business.feature.user.application.model.response.RegisterUserResponse;
import az.bron.business.feature.user.domain.model.User;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class AuthenticationFacade {
    private final AuthenticationService authenticationService;
    private final JwtService jwtService;
    private final RoleService roleService;

    public LoginResponse login(LoginUserRequest loginUserRequest) {
        User user = new User();
        user.setEmail(loginUserRequest.getEmail());
        user.setPassword(loginUserRequest.getPassword());

        User authenticatedUser = authenticationService.authenticate(user);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        return loginResponse;
    }

    public RegisterUserResponse signup(RegisterUserRequest registerUserRequest) {
        User user = new User();
        user.setEmail(registerUserRequest.getEmail());
        user.setPassword(registerUserRequest.getPassword());
        user.setFullName(registerUserRequest.getFullName());
        User authenticatedUser = authenticationService.signup(user);

        Optional<Role> optionalRole = roleService.findByName(RoleEnum.USER);

        if (optionalRole.isEmpty()) {
            return null;
        }

        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setEmail(authenticatedUser.getEmail());
        registerUserResponse.setFullName(authenticatedUser.getFullName());
        return registerUserResponse;


    }

    public GetUserResponse getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        GetUserResponse getUserResponse = new GetUserResponse();
        getUserResponse.setEmail(currentUser.getEmail());
        getUserResponse.setFullName(currentUser.getFullName());


        return getUserResponse;
    }
}
