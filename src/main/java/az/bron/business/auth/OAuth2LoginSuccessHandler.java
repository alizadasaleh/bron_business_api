package az.bron.business.auth;

import az.bron.business.config.JwtService;
import az.bron.business.feature.user.domain.model.User;
import az.bron.business.feature.user.domain.repository.UserRepository;
import az.bron.business.feature.user.domain.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtService jwtService;
    private final UserService userService;

    public OAuth2LoginSuccessHandler(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        // Retrieve the user's email from authentication
        OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
        OAuth2User oauthUser = oauthToken.getPrincipal();

        // Get the email from the user's attributes
        String email = (String) oauthUser.getAttributes().get("email");

        User user = userService.findByEmail(email).orElse(null);
        // Load UserDetails by email

        // Generate JWT using UserDetails
        String token = jwtService.generateToken(user);

        // Set JWT in response header or body
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Write token to response body
        response.getWriter().write("{\"token\": \"" + token + "\"}");
        response.getWriter().flush();
    }
}
