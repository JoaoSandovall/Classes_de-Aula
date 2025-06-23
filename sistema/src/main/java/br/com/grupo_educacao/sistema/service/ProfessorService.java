// no arquivo service/ProfessorService.java
package br.com.grupo_educacao.sistema.service;

import br.com.grupo_educacao.sistema.model.Professor;
import br.com.grupo_educacao.sistema.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> listarTodos() {
        return professorRepository.findAll();
    }

    public void salvar(Professor professor) {
        professorRepository.save(professor);
    }

    public Professor buscarPorId(Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        professorRepository.deleteById(id);
    }
}