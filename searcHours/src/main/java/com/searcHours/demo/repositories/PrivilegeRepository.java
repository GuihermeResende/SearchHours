package com.searcHours.demo.repositories;
import com.searcHours.demo.domain.models.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

        Optional<Privilege> findByName(String nome);
}


