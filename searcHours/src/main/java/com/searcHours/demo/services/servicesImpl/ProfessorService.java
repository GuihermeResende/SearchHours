package com.searcHours.demo.services.servicesImpl;

import com.searcHours.demo.domain.models.AtividadeComplementar;
import com.searcHours.demo.domain.models.Professor;
import com.searcHours.demo.repositories.AtividadeComplementarRepository;
import com.searcHours.demo.repositories.ProfessorRepository;
import com.searcHours.demo.repositories.RoleRepository;
import com.searcHours.demo.services.interfaces.IProfessorService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfessorService implements IProfessorService {

    private ProfessorRepository _professorRepository;
    private RoleRepository _roleRepository;
    private AtividadeComplementarRepository _atividadeRepository;

    public ProfessorService(ProfessorRepository professorRepository, RoleRepository roleRepository, AtividadeComplementarRepository atividadeComplementarRepository) {
        _professorRepository = professorRepository;
        _roleRepository = roleRepository;
        _atividadeRepository = atividadeComplementarRepository;
    }

    @Override
    public List<Professor> listProfessores() {
        return _professorRepository.findAll();
    }

    @Override
    public Professor getProfessorById(Long id) {
        return _professorRepository.findById(id).get();
    }


    @Override
    public AtividadeComplementar recomendarAtividade(Long id, AtividadeComplementar atividade) {
        Professor findIdProfessor = _professorRepository.findById(id).get();

        if (findIdProfessor == null) {
            throw new IllegalArgumentException("Não existe professor com esse ID");
        }

        AtividadeComplementar atividadeComplementar = new AtividadeComplementar();
        atividadeComplementar.setTitulo(atividade.getTitulo());

        _atividadeRepository.save(atividadeComplementar);

        return atividadeComplementar;
    }

}
