package com.searcHours.demo.services.servicesImpl;

import com.searcHours.demo.domain.DTOs.SignUpDTO;
import com.searcHours.demo.domain.models.*;
import com.searcHours.demo.repositories.AlunoRepository;
import com.searcHours.demo.repositories.ProfessorRepository;
import com.searcHours.demo.repositories.RoleRepository;
import com.searcHours.demo.repositories.UserRepository;
import com.searcHours.demo.services.interfaces.IUserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService, UserDetailsService {

    private AlunoRepository _alunoRepository;
    private ProfessorRepository _professorRepository;
    private RoleRepository _roleRepository;
    private UserRepository _userRepository;

    public UserService(AlunoRepository alunoRepository, ProfessorRepository professorRepository, UserRepository userRepository) {
        _alunoRepository = alunoRepository;
        _professorRepository = professorRepository;
        _userRepository = userRepository;
    }

    @Override
    public Boolean SignUp(SignUpDTO signUpDTO) {

        if (!signUpDTO.getSenha().equals(signUpDTO.getConfirmarSenha())) {
            throw new IllegalArgumentException("a senha confirmada é inválida");
        }

        Optional<User> userExists = _userRepository.findByNome(signUpDTO.getNome());
        if (userExists.isPresent()) {
            throw new IllegalArgumentException("O usuário já existe");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        Role findRole = _roleRepository.findByName("ROLE_USER").get();

        User user = new User();
        user.setNome(signUpDTO.getNome());
        user.setRegistro(signUpDTO.getRegistro());
        user.setRoles(Arrays.asList(findRole));

        _userRepository.save(user);

        if (!signUpDTO.isProfessor()) {
            Aluno aluno = new Aluno();

            aluno.setUser(user);
            aluno.setCurso(signUpDTO.getCurso());
            _alunoRepository.save(aluno);
        }
        return true;
    }

    public Boolean deleteUser(Long userId) {
        User findUser = _userRepository.findById(userId).orElse(null);

        if (findUser == null) {
            throw new IllegalArgumentException("Usuário não existe");
        }

        _userRepository.delete(findUser);
        return true;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
