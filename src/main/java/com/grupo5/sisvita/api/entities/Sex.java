package com.grupo5.sisvita.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Sex {
    @Id
    private String sex;
}
