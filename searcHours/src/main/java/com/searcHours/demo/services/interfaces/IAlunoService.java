package com.searcHours.demo.services.interfaces;
import com.searcHours.demo.domain.DTOs.SignUpDTO;
import com.searcHours.demo.domain.models.Aluno;
import com.searcHours.demo.domain.models.AtividadeComplementar;

import java.util.List;

public interface IAlunoService {

    List<Aluno> listAlunos();
    Aluno getAlunoById(Long id);
    boolean postarAtividade (Long id, AtividadeComplementar atividade);

}
