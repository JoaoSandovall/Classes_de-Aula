package br.com.grupo_educacao.sistema.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String disciplina;

    @OneToMany(mappedBy = "professor")
    private List<SalaDeAula> salasDeAula;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public List<SalaDeAula> getSalasDeAula() {
        return salasDeAula;
    }

    public void setSalasDeAula(List<SalaDeAula> salasDeAula) {
        this.salasDeAula = salasDeAula;
    }
}