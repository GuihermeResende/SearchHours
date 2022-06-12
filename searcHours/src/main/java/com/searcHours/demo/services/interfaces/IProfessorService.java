package com.searcHours.demo.services.interfaces;

import com.searcHours.demo.domain.DTOs.SignUpDTO;
import com.searcHours.demo.domain.models.Aluno;
import com.searcHours.demo.domain.models.AtividadeComplementar;
import com.searcHours.demo.domain.models.Professor;

import java.util.List;

public interface IProfessorService {

    List<Professor> listProfessores();
    Professor getProfessorById(Long id);
    AtividadeComplementar recomendarAtividade (Long id, AtividadeComplementar atividade);

}
