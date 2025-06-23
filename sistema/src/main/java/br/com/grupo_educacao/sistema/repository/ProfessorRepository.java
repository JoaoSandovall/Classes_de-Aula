// no arquivo repository/ProfessorRepository.java
package br.com.grupo_educacao.sistema.repository;

import br.com.grupo_educacao.sistema.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}