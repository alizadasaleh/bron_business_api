package az.bron.business.feature.user.application.facade;


import az.bron.business.config.JwtService;
import az.bron.business.feature.role.domain.model.Role;
import az.bron.business.feature.role.domain.model.RoleEnum;
import az.bron.business.feature.role.domain.service.RoleService;
import az.bron.business.feature.user.application.exception.UserAlreadyExists;
import az.bron.business.feature.user.application.mapper.UserMapper;
import az.bron.business.feature.user.application.model.request.AuthenticationService;
import az.bron.business.feature.user.application.model.request.LoginUserRequest;
import az.bron.business.feature.user.application.model.request.RegisterUserRequest;
import az.bron.business.feature.user.application.model.response.GetUserResponse;
import az.bron.business.feature.user.application.model.response.LoginResponse;
import az.bron.business.feature.user.application.model.response.RegisterUserResponse;
import az.bron.business.feature.user.domain.model.ConfirmationToken;
import az.bron.business.feature.user.domain.model.User;
import az.bron.business.feature.user.domain.repository.ConfirmationTokenRepository;
import az.bron.business.feature.user.domain.repository.UserRepository;
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
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;


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
        if(userRepository.findByEmail(registerUserRequest.getEmail()).isPresent()) {
            throw new UserAlreadyExists(registerUserRequest.getEmail());
        }
        User user = userMapper.toModel(registerUserRequest);

        User registeredUser = authenticationService.signup(user);

        ConfirmationToken confirmationToken = new ConfirmationToken();
        confirmationToken.setUser(registeredUser);
        confirmationTokenRepository.save(confirmationToken);

        Optional<Role> optionalRole = roleService.findByName(RoleEnum.USER);

        if (optionalRole.isEmpty()) {
            return null;
        }

        return userMapper.toRegisterUserResponse(registeredUser);


    }

    public GetUserResponse getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        GetUserResponse getUserResponse = new GetUserResponse();
        getUserResponse.setEmail(currentUser.getEmail());
        getUserResponse.setFullName(currentUser.getFullName());


        return getUserResponse;
    }

    String confirmEmail(String confirmationToken){
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if(token != null)
        {
            User user = userRepository.findByEmailIgnoreCase(token.getUser().getEmail());
            user.setEnabled(true);
            userRepository.save(user);
            return "Email verified successfully!";
        }
        return "Error: Couldn't verify email";
    }
}
