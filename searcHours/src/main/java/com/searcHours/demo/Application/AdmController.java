package com.searcHours.demo.Application;

import com.searcHours.demo.domain.DTOs.SignUpDTO;
import com.searcHours.demo.services.servicesImpl.AdmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/adm")
public class AdmController {

    AdmService _admService;

    public AdmController(AdmService admService) {
        _admService = admService;
    }

    @PostMapping ("/add-new-professor")
    public ResponseEntity listMeusChats(@RequestBody SignUpDTO signUpDTO) {
        try{
            return ResponseEntity.ok(_admService.addNewProfessor(signUpDTO));
        }catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/aprova")
    public ResponseEntity createChat(@RequestBody Long atividadeId) {
        try {
            return ResponseEntity.ok(_admService.aprova(atividadeId));
        }catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
