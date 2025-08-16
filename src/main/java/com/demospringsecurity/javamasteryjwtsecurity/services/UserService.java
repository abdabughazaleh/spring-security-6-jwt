package com.demospringsecurity.javamasteryjwtsecurity.services;

import com.demospringsecurity.javamasteryjwtsecurity.model.dto.LoginDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final AuthenticationManager authenticationManager;
    private final JWTTokenService jwtTokenService;

    public UserService(AuthenticationManager authenticationManager, JWTTokenService jwtTokenService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
    }

    public String login(LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.username(), loginDTO.password())
        );
        return this.jwtTokenService.generateJWTToken(authentication);
    }
}
