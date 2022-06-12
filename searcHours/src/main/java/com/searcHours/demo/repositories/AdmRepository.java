package com.searcHours.demo.repositories;

import com.searcHours.demo.domain.models.ADM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdmRepository extends JpaRepository<ADM, Long> {

    Optional<List<ADM>> findByRoles_Name(String nome);

}