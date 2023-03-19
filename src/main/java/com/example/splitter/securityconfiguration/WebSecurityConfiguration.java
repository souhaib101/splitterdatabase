package com.example.splitter.securityconfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

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
    public SecurityFilterChain configure(HttpSecurity chainBuilder) throws Exception {
        chainBuilder.authorizeHttpRequests(configurer -> configurer
                        .requestMatchers("/public", "/css/*").permitAll()
                        .anyRequest().authenticated())
                .logout()
                .clearAuthentication(true)
                .deleteCookies()
                .permitAll()
                .and()
                .oauth2Login(config -> config.userInfoEndpoint(
                        info -> info.userService(new OAuthToUserService(organisators))
                ));

        return chainBuilder.build();
    }




}
