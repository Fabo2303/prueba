package com.grupo5.sisvita.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Document {
    @Id
    private String type;
    private int length;
}
