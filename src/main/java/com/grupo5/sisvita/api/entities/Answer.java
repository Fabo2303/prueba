package com.grupo5.sisvita.api.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idResolvedTest")
    private ResolvedTest resolvedTest;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idQuestion")
    private Question question;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idAlternative")
    private Alternative alternative;
}
