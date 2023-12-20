package com.banco.APIBanco.service;

import com.banco.APIBanco.controller.model.AuthResponse;
import com.banco.APIBanco.controller.model.AuthenticationRequest;
import com.banco.APIBanco.controller.model.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse authenticate(AuthenticationRequest request);
}
