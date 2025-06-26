package br.com.grupo_educacao.sistema.service;

import br.com.grupo_educacao.sistema.model.Professor;
import br.com.grupo_educacao.sistema.model.SalaDeAula;
import br.com.grupo_educacao.sistema.repository.ProfessorRepository;
import br.com.grupo_educacao.sistema.repository.SalaDeAulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private SalaDeAulaRepository salaDeAulaRepository;

    public List<Professor> listarTodos() {
        return professorRepository.findAll();
    }

    public void salvar(Professor professor) {
        professorRepository.save(professor);
    }

    public Professor buscarPorId(Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    // DELETAR UM PROFESSOR VINCULADO À UMA SALA
    @Transactional
    public void deletar(Long id) {
        Professor professor = buscarPorId(id);
        if (professor != null) {
            //1. Para cada sala de aula que este professor é responsável...
            for (SalaDeAula sala : professor.getSalasDeAula()) {
                // professor daquela sala como nulo.
                sala.setProfessor(null);
                // Salva a alteração na sala para remover o vínculo.
                salaDeAulaRepository.save(sala);
            }
            professorRepository.delete(professor);
        }
    }
}