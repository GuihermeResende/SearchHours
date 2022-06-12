package com.searcHours.demo.repositories;

import com.searcHours.demo.domain.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessorRepository  extends JpaRepository<Professor, Long> {

    Optional<Professor> findById (Long Id);

}
