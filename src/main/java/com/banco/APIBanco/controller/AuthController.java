package com.banco.APIBanco.controller;

import com.banco.APIBanco.service.AuthService;
import com.banco.APIBanco.controller.model.AuthResponse;
import com.banco.APIBanco.controller.model.AuthenticationRequest;
import com.banco.APIBanco.controller.model.RegisterRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Auth", description = "the auth API")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;

    @PreAuthorize("permitAll")
    @Operation(summary = "Create Authenticate", description = "Unrestricted method.")
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PreAuthorize("permitAll")
    @Operation(summary = "Get Authenticate", description = "Unrestricted method.")
    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
