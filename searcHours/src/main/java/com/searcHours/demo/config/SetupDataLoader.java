package com.searcHours.demo.config;

import com.searcHours.demo.domain.models.ADM;
import com.searcHours.demo.domain.models.Aluno;
import com.searcHours.demo.domain.models.Privilege;
import com.searcHours.demo.domain.models.Role;
import com.searcHours.demo.repositories.AdmRepository;
import com.searcHours.demo.repositories.AlunoRepository;
import com.searcHours.demo.repositories.PrivilegeRepository;
import com.searcHours.demo.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class SetupDataLoader implements
        ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AdmRepository admRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;
        Privilege readPrivilege
                = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege
                = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        List<Privilege> adminPrivileges = Arrays.asList(
                readPrivilege, writePrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));
        createRoleIfNotFound("ROLE_PROFESSOR", Arrays.asList(readPrivilege));

        Role adminRole = roleRepository.findByName("ROLE_ADMIN").orElse(null);

        List<ADM> findADM = admRepository.findByRoles_Name("ROLE_ADMIN").orElse(null);
        if (findADM == null) {

            ADM adm = new ADM();
            adm.setUsername("ADMIN");
            adm.setSenha(passwordEncoder.encode("test"));
            adm.setRoles(Arrays.asList(adminRole));
            admRepository.save(adm);
        }
        alreadySetup = true;
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(String name) {

        Privilege privilege = privilegeRepository.findByName(name).orElse(null);
        if (privilege == null) {
            privilege = new Privilege();
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    Role createRoleIfNotFound(
            String name, List<Privilege> privileges) {

        Role role = roleRepository.findByName(name).orElse(null);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }

}