package com.searcHours.demo.domain.models;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private User user;

    @OneToMany(mappedBy = "professor")
    private List<AtividadeComplementar> atividades;
}
