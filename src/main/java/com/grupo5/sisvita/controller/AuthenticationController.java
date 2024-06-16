package com.grupo5.sisvita.controller;

import com.grupo5.sisvita.api.entities.Usuario;
import com.grupo5.sisvita.api.repositories.UsuarioRepository;
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
    private UsuarioRepository userRepository;

    @PreAuthorize("permitAll")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Validated AuthenticationRequest authRequest) {
        Usuario user = userRepository.findByNombreUsuario(authRequest.getUsername()).orElse(null);

        if (user == null) {
            return ResponseEntity.status(404).body("El usuario no existe");
        }

        AuthenticationResponse response = authenticationService.login(authRequest);
        if (response.getJwt() == null) {
            return ResponseEntity.status(404).body("La contraseña es incorrecta");
        }

        if (user.getRol() == null) {
            return ResponseEntity.status(404).body("El usuario no tiene un rol asignado");
        }

        if (!user.isEnabled()) {
            return ResponseEntity.status(404).body("El usuario no está habilitado");
        }
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("permitAll")
    @GetMapping("/public-access")
    public ResponseEntity<?> publicAccess() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "public access");
        return ResponseEntity.ok(response);
    }
}
