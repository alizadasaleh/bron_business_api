package az.bron.business.config;

import az.bron.business.feature.role.application.exception.RoleNotFoundException;
import az.bron.business.feature.role.domain.model.Role;
import az.bron.business.feature.role.domain.model.RoleEnum;
import az.bron.business.feature.role.domain.repository.RoleRepository;
import az.bron.business.feature.user.domain.model.User;
import az.bron.business.feature.user.domain.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public CustomOAuth2UserService(JwtService jwtService, RoleRepository roleRepository, UserRepository userRepository) {
        this.jwtService = jwtService;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }



    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        Map<String, Object> attributes = oAuth2User.getAttributes();

        String email = (String) attributes.get("email");


        Boolean emailVerified = (Boolean) attributes.get("email_verified");
        String name = (String) attributes.get("name");
        String firstName = (String) attributes.get("given_name");
        String lastName = (String) attributes.get("family_name");
//        String pictureUrl = (String) attributes.get("picture");

        Role role = roleRepository.findByName(RoleEnum.USER).orElseThrow(RoleNotFoundException::new);

        User user = userRepository.findByEmail(email)
                .orElseGet(() -> {
                    User newUser = new User();
                    newUser.setEmail(email);
                    newUser.setFullName(name);
                    newUser.setEmailVerified(emailVerified);
                    newUser.setEnabled(true);
                    newUser.setFirstName(firstName);
                    newUser.setLastName(lastName);
                    newUser.setRole(role);

                    return userRepository.save(newUser);
                });

        return oAuth2User;

    }
}
