package LikeLion8.weeks1.infra;

import LikeLion8.weeks1.entity.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Map;

@Service
public class NaverOAuth2Service implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {   // NaverOAuth2Service 네이버로 로그인 연동
    private static final Logger logger = LoggerFactory.getLogger(NaverOAuth2Service.class);
    private final UserRepository userRepository;

    public NaverOAuth2Service(
            @Autowired UserRepository userRepository,
            @Autowired HttpSession httpSession
    ) {
        this.userRepository = userRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String usernameAttributeName = userRequest
                .getClientRegistration()
                .getProviderDetails()
                .getUserInfoEndpoint()
                .getUserNameAttributeName();

        Map<String, Object> attributeMap = oAuth2User.getAttributes();
        Map<?, ?> responseMap = (Map<?, ?>) attributeMap.get("response");

        DefaultOAuth2User defaultOAuth2User = new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")),
                (Map<String, Object>) attributeMap,
                "email"
        );

        return defaultOAuth2User;
    }
}

