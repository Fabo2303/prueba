package com.grupo5.sisvita.utilz;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordVerificationExample {

    public static void main(String[] args) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        // Supongamos que este es el hash almacenado de la contraseña original
        String storedHash = "$2a$10$DuWg72AA2rUTdViQ2NKrTuDgX5FFjiDDfiDD1zJoDk3OkL8dmkYXu";

        // Contraseña ingresada por el usuario
        String inputPassword = "clave123";

        // Verificar la contraseña ingresada contra el hash almacenado
        boolean isPasswordMatch = encoder.matches(inputPassword, storedHash);
        System.out.println("¿La contraseña coincide? " + isPasswordMatch);
    }
}

