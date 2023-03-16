package com.example.splitter.securityconfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.DefaultSecurityFilterChain;

import java.util.*;
@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration {


    private final List<String> organisators;

    public WebSecurityConfiguration(
            @Value("${splitter.rollen.organisator}")
            List<String> organisators) {
        this.organisators = organisators;
    }

    @Bean
    DefaultSecurityFilterChain configure(HttpSecurity chainBuilder) throws Exception {
        chainBuilder.authorizeHttpRequests(
                        configurer -> configurer
                                .requestMatchers( "/error").permitAll()
                                .anyRequest().authenticated()
                )
                .csrf().ignoringRequestMatchers("/api/**")
                .and()
                .oauth2Login();

        return chainBuilder.logout()
                .clearAuthentication(true)
                .deleteCookies()
                .invalidateHttpSession(true)
                .permitAll()
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(createUserService())
                .and()
                .and().build();

    }

    @Bean
     OAuth2UserService<OAuth2UserRequest, OAuth2User> createUserService() {
        return new OAuth2UserService<>() {
            final DefaultOAuth2UserService defaultService = new DefaultOAuth2UserService();
            @Override
            public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

                    OAuth2User oauth2User = defaultService.loadUser(userRequest);

                    //keep existing attributes
                    Set<GrantedAuthority> authorities = new HashSet<>();
                    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

                    Map<String, Object> attributes = oauth2User.getAttributes();
                    String login = attributes.get("login").toString();
                    Map<String, Object> extendedAttributes = new HashMap<>(attributes);

                    if (organisators.contains(login)) {
                        authorities.add(new SimpleGrantedAuthority("ROLE_ORGANISATOR"));
                    }

                    return new DefaultOAuth2User(authorities, extendedAttributes, "login");
            }
        };
    }


}
