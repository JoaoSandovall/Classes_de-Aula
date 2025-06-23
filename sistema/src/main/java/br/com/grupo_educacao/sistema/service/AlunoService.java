// no arquivo src/main/java/br/com/grupo_educacao/sistema/service/AlunoService.java
package br.com.grupo_educacao.sistema.service;

import br.com.grupo_educacao.sistema.model.Aluno;
import br.com.grupo_educacao.sistema.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Marca esta classe como um serviço de negócio
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public void salvar(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        alunoRepository.deleteById(id);
    }
}