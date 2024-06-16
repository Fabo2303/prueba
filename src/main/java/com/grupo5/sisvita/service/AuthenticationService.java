package com.grupo5.sisvita.service;

import com.grupo5.sisvita.api.entities.Usuario;
import com.grupo5.sisvita.api.repositories.UsuarioRepository;
import com.grupo5.sisvita.dto.AuthenticationRequest;
import com.grupo5.sisvita.dto.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private JwtService jwtService;

    public AuthenticationResponse login(AuthenticationRequest authRequest) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                authRequest.getUsername(), authRequest.getPassword());
        Usuario user;
        try {
            authenticationManager.authenticate(authToken);
            user = userRepository.findByNombreUsuario(authRequest.getUsername()).orElse(null);
        } catch (Exception e) {
            return new AuthenticationResponse(null);
        }

        String jwt = jwtService.generateToken(user, generateExtraClaims(user));

        return new AuthenticationResponse(jwt);
    }

    private Map<String, Object> generateExtraClaims(Usuario user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", user.getUsername());
        extraClaims.put("role", user.getRol().name());
        extraClaims.put("permissions", user.getAuthorities());
        return extraClaims;
    }
}
