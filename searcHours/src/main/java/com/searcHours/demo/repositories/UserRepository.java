package com.searcHours.demo.repositories;

import com.searcHours.demo.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByNome (String nome);
    Optional<User> findByRegistro (Long Registro);
    Optional<User> findBySenha (String Senha);

}
