package com.searcHours.demo.services.servicesImpl;

import com.searcHours.demo.domain.models.Aluno;
import com.searcHours.demo.domain.models.AtividadeComplementar;
import com.searcHours.demo.repositories.AlunoRepository;
import com.searcHours.demo.repositories.AtividadeComplementarRepository;
import com.searcHours.demo.repositories.RoleRepository;
import com.searcHours.demo.services.interfaces.IAlunoService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlunoService implements IAlunoService {

    private AlunoRepository _alunoRepository;
    private RoleRepository _roleRepository;
    private AtividadeComplementarRepository _atividadeRepository;

    public AlunoService (AlunoRepository alunoRepository, RoleRepository roleRepository, AtividadeComplementarRepository atividadeRepository) {
        _alunoRepository = alunoRepository;
        _roleRepository = roleRepository;
        _atividadeRepository = atividadeRepository;
    }

    @Override
    public List<Aluno> listAlunos() {
        return _alunoRepository.findAll();
    }

    @Override
    public Aluno getAlunoById(Long id) {
        Aluno findIdAluno = _alunoRepository.findById(id).get();

        if (findIdAluno == null) {
            throw new IllegalArgumentException("Não existe aluno com esse ID");
        }

        return findIdAluno;
    }

    @Override
    public boolean postarAtividade(Long id, AtividadeComplementar atividade) {
        Aluno findIdAluno = _alunoRepository.findById(id).get();

        if (findIdAluno == null) {
            throw new IllegalArgumentException("Não existe aluno com esse ID");
        }

        AtividadeComplementar atividadeComplementar = new AtividadeComplementar();
        atividadeComplementar.setTitulo(atividade.getTitulo());
        atividadeComplementar.setDuracao(atividade.getDuracao());
        atividadeComplementar.setEstado(1);
        getTotalCarga(id);

        _atividadeRepository.save(atividadeComplementar);

        return true;
    }

    public Integer getCarga (Long atividadeId) {
        AtividadeComplementar findEstadoAtividade = _atividadeRepository.findEstadoById(atividadeId).get();
        if (findEstadoAtividade.equals(4)) {
            return _atividadeRepository.findDuracaoById(atividadeId).get();
        }else
            return null;
    }

    public Integer getTotalCarga (Long atividadeId) {
        Integer ativ = 0;

        ativ = ativ + (getCarga(atividadeId));
        return ativ;
    }

}
