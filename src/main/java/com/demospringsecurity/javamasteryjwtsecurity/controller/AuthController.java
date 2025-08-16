package com.demospringsecurity.javamasteryjwtsecurity.controller;

import com.demospringsecurity.javamasteryjwtsecurity.model.dto.AuthRep;
import com.demospringsecurity.javamasteryjwtsecurity.model.dto.LoginDTO;
import com.demospringsecurity.javamasteryjwtsecurity.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<AuthRep> login(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(new AuthRep(this.userService.login(loginDTO)));
    }
}
