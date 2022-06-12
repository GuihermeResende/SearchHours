package com.searcHours.demo.repositories;

import com.searcHours.demo.domain.models.AtividadeComplementar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AtividadeComplementarRepository extends JpaRepository<AtividadeComplementar, Long> {
    Optional<AtividadeComplementar> findEstadoById (Long id);
    Optional<Integer> findDuracaoById (Long id);
}
