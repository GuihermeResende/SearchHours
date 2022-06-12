package com.searcHours.demo.domain.DTOs;

import lombok.Data;

@Data
public class SignUpDTO {

    private Long id;
    private String nome;
    private String senha;
    private String confirmarSenha;
    private String email;
    private Long registro;
    private String curso;
    private boolean professor;

}
