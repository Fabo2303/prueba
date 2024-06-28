package com.grupo5.sisvita.api.dto.requests;

import com.grupo5.sisvita.api.entities.User;
import com.grupo5.sisvita.utilz.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String username;
    private String password;
    private Role role;
    private PersonaRequest personaRequest;

    public static User toEntity(UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setRole(userRequest.getRole());
        return user;
    }
}
