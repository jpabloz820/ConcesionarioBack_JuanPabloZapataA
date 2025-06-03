package com.concesionario.ordenes_trabajo.controller;

import com.concesionario.ordenes_trabajo.security.JwtUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {
        // Autenticamos sin guardar la variable si no se usará
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        // Generamos y retornamos el token
        return jwtUtil.generateToken(request.getUsername());
    }

    // DTO interno con campos privados y acceso por getters/setters
    @Getter
    @Setter
    static class AuthRequest {
        private String username;
        private String password;
    }
}
