package az.bron.business.feature.user.application.facade;


import az.bron.business.config.EmailService;
import az.bron.business.config.JwtService;
import az.bron.business.feature.role.application.exception.RoleNotFoundException;
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
import az.bron.business.feature.user.domain.service.ConfirmationTokenService;
import az.bron.business.feature.user.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class AuthenticationFacade {

    @Value("${APP_URL}")
    private String applicationUrl;

    private final AuthenticationService authenticationService;
    private final JwtService jwtService;
    private final RoleService roleService;
    private final UserMapper userMapper;
    private final EmailService emailService;
    private final ConfirmationTokenService confirmationTokenService;
    private final UserService userService;


    public LoginResponse login(LoginUserRequest loginUserRequest) {
        User user = userMapper.toModel(loginUserRequest);

        User authenticatedUser = authenticationService.authenticate(user);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        return loginResponse;
    }

    public RegisterUserResponse register(RegisterUserRequest registerUserRequest) {
        if(userService.findByEmail(registerUserRequest.getEmail()).isPresent()) {
            throw new UserAlreadyExists(registerUserRequest.getEmail());
        }
        Role role = roleService.findByName(RoleEnum.USER).orElseThrow(RoleNotFoundException::new);

        User user = userMapper.toModel(registerUserRequest);

        user.setRole(role);

        User registeredUser = authenticationService.register(user);

        ConfirmationToken confirmationToken = new ConfirmationToken();
        confirmationToken.setUser(registeredUser);
        confirmationTokenService.create(confirmationToken);

        sendConfirmationTokenToUser(user, confirmationToken);

        return userMapper.toRegisterUserResponse(registeredUser);

    }

    @Async
    protected void sendConfirmationTokenToUser(User user, ConfirmationToken confirmationToken) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setText("To confirm your account, please click here : "
                    + applicationUrl + "/auth/confirm-account?token=" + confirmationToken.getConfirmationToken());

            emailService.sendEmail(mailMessage);
        } catch (MailException e) {
            log.error("Failed to send confirmation email to {}: {}", user.getEmail(), e.getMessage());
        }
    }

    public GetUserResponse getCurrentUser() {
        return userMapper.toGetResponse(authenticationService.getCurrentUser());
    }

    public String confirmEmail(String confirmationToken){
        ConfirmationToken token = confirmationTokenService.findByConfirmationToken(confirmationToken);

        if(token != null)
        {
            User user = userService.findByEmailIgnoreCase(token.getUser().getEmail());
            user.setEnabled(true);
            user.setEmailVerified(true);
            userService.update(user);
            return "Email verified successfully!";
        }
        return "Error: Couldn't verify email";
    }
}
