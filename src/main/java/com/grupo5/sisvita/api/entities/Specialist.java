package com.grupo5.sisvita.api.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Specialist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String license;
    private String specialty;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
}
