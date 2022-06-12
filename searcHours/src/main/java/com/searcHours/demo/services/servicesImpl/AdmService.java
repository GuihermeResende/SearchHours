package com.searcHours.demo.services.servicesImpl;

import com.searcHours.demo.domain.DTOs.SignUpDTO;
import com.searcHours.demo.domain.models.*;
import com.searcHours.demo.repositories.*;
import com.searcHours.demo.services.interfaces.IAdmService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;

public class AdmService implements IAdmService {

    private UserRepository _userRepository;
    private ProfessorRepository _professorRepository;
    private RoleRepository _roleRepository;
    private AtividadeComplementarRepository _atividadeRepository;

    public AdmService (UserRepository userRepository, ProfessorRepository professorRepository, RoleRepository roleRepository, AtividadeComplementarRepository atividadeComplementarRepository) {
        _userRepository = userRepository;
        _professorRepository = professorRepository;
        _roleRepository = roleRepository;
        _atividadeRepository = atividadeComplementarRepository;
    }

    @Override
    public Professor addNewProfessor(SignUpDTO signUpDTO) {

        UserDetails authentication = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"))) {
            throw new IllegalArgumentException("Somente administradores podem adicionar um professor");
        }

        Role findRole = _roleRepository.findByName("ROLE_PROFESSOR").get();
        User user = new User();
        user.setNome(signUpDTO.getNome());
        user.setRegistro(signUpDTO.getRegistro());
        user.setRoles(Arrays.asList(findRole));
        _userRepository.save(user);

        Professor professor = new Professor();
        professor.setUser(user);
        _professorRepository.save(professor);

        return professor;
    }

    public Boolean aprova(Long atividadeId) {
        AtividadeComplementar findAtividade = _atividadeRepository.findById(atividadeId).get();
        findAtividade.setEstado(4);
        return true;
    }

}
