// no arquivo controller/ProfessorController.java
package br.com.grupo_educacao.sistema.controller;

import br.com.grupo_educacao.sistema.model.Professor;
import br.com.grupo_educacao.sistema.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/professores") // Define a URL base para todos os métodos deste controller
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public String listarProfessores(Model model) {
        model.addAttribute("professores", professorService.listarTodos());
        return "lista-professores";
    }

    @GetMapping("/novo")
    public String mostrarFormularioDeNovoProfessor(Model model) {
        model.addAttribute("professor", new Professor());
        return "form-professor";
    }

    @PostMapping("/salvar")
    public String salvarProfessor(Professor professor) {
        professorService.salvar(professor);
        return "redirect:/professores";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicao(@PathVariable Long id, Model model) {
        model.addAttribute("professor", professorService.buscarPorId(id));
        return "form-professor";
    }

    @GetMapping("/deletar/{id}")
    public String deletarProfessor(@PathVariable Long id) {
        professorService.deletar(id);
        return "redirect:/professores";
    }
}