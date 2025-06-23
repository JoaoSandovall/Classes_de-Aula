// no arquivo src/main/java/br/com/grupo_educacao/sistema/repository/AlunoRepository.java
package br.com.grupo_educacao.sistema.repository;

import br.com.grupo_educacao.sistema.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

// Esta interface herda todos os métodos de CRUD (save, findById, findAll, deleteById)
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}