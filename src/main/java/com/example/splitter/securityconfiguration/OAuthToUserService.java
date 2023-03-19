package com.example.splitter.securityconfiguration;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OAuthToUserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final DefaultOAuth2UserService defaultService = new DefaultOAuth2UserService();

    List<String> admins = new ArrayList<>();
    public OAuthToUserService(List<String> admins) {
        this.admins.addAll(admins);
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User originalUser = defaultService.loadUser(userRequest);
        Set<GrantedAuthority> authorities = new HashSet<>(originalUser.getAuthorities());
        for (String admin: admins) {
            if (admin.equals(originalUser.getAttribute("login"))) {
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                System.out.println(originalUser.getAttribute("login") +" :added as admin.");
            }
        }
        return new DefaultOAuth2User(authorities, originalUser.getAttributes(), "id");
    }

}
