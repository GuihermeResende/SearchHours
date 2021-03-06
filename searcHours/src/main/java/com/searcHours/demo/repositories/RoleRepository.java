package com.searcHours.demo.repositories;

import com.searcHours.demo.domain.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository <Role, Long> {

    Optional<Role> findByName (String nome);

}
