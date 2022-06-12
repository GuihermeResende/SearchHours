package com.searcHours.demo.domain.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String curso;
    private User user;

    @OneToMany (mappedBy = "aluno")
    private List<AtividadeComplementar> atividades;

}
