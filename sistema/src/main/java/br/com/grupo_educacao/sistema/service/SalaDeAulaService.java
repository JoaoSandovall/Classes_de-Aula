package br.com.grupo_educacao.sistema.service;

import br.com.grupo_educacao.sistema.model.SalaDeAula;
import br.com.grupo_educacao.sistema.repository.SalaDeAulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SalaDeAulaService {

    @Autowired
    private SalaDeAulaRepository salaDeAulaRepository;

    public List<SalaDeAula> listarTodos() {
        return salaDeAulaRepository.findAll();
    }

    public void salvar(SalaDeAula salaDeAula) {
        salaDeAulaRepository.save(salaDeAula);
    }

    public SalaDeAula buscarPorId(Long id) {
        return salaDeAulaRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        salaDeAulaRepository.deleteById(id);
    }
}