package com.grupo5.sisvita.controller;

import com.grupo5.sisvita.api.entities.User;
import com.grupo5.sisvita.api.repositories.UserRepository;
import com.grupo5.sisvita.dto.AuthenticationRequest;
import com.grupo5.sisvita.dto.AuthenticationResponse;
import com.grupo5.sisvita.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserRepository userRepository;

    @PreAuthorize("permitAll")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Validated AuthenticationRequest authRequest) {
        User user = userRepository.findByUsername(authRequest.getUsername()).orElse(null);
        Map<String, String> responseBody= new HashMap<>();

        if (user == null) {
            responseBody.put("error", "El usuario no existe");
            return ResponseEntity.status(404).body(responseBody);
        }

        AuthenticationResponse response = authenticationService.login(authRequest);
        if (response.getJwt() == null) {
            responseBody.put("error", "La contraseña es incorrecta");
            return ResponseEntity.status(404).body(responseBody);
        }

        if (!user.isEnabled()) {
            responseBody.put("error", "El usuario no está habilitado");
            return ResponseEntity.status(404).body(responseBody);
        }
        responseBody.put("jwt", response.getJwt());
        return ResponseEntity.ok(responseBody);
    }

    @PreAuthorize("permitAll")
    @GetMapping("/public-access")
    public ResponseEntity<?> publicAccess() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "public access");
        return ResponseEntity.ok(response);
    }
}
