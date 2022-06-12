package com.searcHours.demo.Application;

import com.searcHours.demo.domain.models.AtividadeComplementar;
import com.searcHours.demo.services.servicesImpl.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/aluno")
public class AlunoController {

   AlunoService _alunoService;

    public AlunoController(AlunoService alunoService) {
        _alunoService = alunoService;
    }

    @GetMapping()
    public ResponseEntity listAlunos() {
        try{
            return ResponseEntity.ok(_alunoService.listAlunos());
        }catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/{id}/{atividade}")
    public ResponseEntity PostarAtividade(@RequestBody Long id, AtividadeComplementar atividade) {
        try{
            return ResponseEntity.ok(_alunoService.postarAtividade(id, atividade));
        }catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/{atividadeId}")
    public ResponseEntity getCaarga(@RequestBody Long atividadeId) {
        try {
            return ResponseEntity.ok(_alunoService.getCarga(atividadeId));
        }catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
