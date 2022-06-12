package com.searcHours.demo.Application;

import com.searcHours.demo.domain.models.AtividadeComplementar;
import com.searcHours.demo.services.servicesImpl.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/professor")
public class ProfessorController {

    ProfessorService _professorService;

    public ProfessorController(ProfessorService professorService) {
        _professorService = professorService;
    }

    @GetMapping()
    public ResponseEntity listProfessores() {
        try{
            return ResponseEntity.ok(_professorService.listProfessores());
        }catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getProfessorById(Long id) {
        try{
            return ResponseEntity.ok(_professorService.getProfessorById(id));
        }catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/recomendar-atividade")
    public ResponseEntity recomendarAtividade(@RequestBody Long id, AtividadeComplementar atividadeComplementar) {
        try {
            return ResponseEntity.ok(_professorService.recomendarAtividade(id, atividadeComplementar));
        }catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
