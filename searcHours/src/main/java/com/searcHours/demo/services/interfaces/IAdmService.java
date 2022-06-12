package com.searcHours.demo.services.interfaces;

import com.searcHours.demo.domain.DTOs.SignUpDTO;
import com.searcHours.demo.domain.models.Professor;

public interface IAdmService {

    Professor addNewProfessor(SignUpDTO signUpDTO);
    Boolean aprova(Long atividadeId);
}
