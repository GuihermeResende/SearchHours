package com.searcHours.demo.domain.models;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class AtividadeComplementar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private Integer duracao;
    private Integer estado;
    private Integer contador;

//    public AtividadeComplementar (String titulo, Integer duracao) {
//        this.titulo = titulo;
//        this.duracao = duracao;
//        this.estado = 1;
//    }


    public Integer aprova () {
        return this.estado = 4;
    }

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

}
