package com.searcHours.demo.repositories;

import com.searcHours.demo.domain.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Optional<Aluno> findById (Long id);

}
