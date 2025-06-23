package br.com.grupo_educacao.sistema.controller;

import br.com.grupo_educacao.sistema.model.Aluno;
import br.com.grupo_educacao.sistema.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // Atenção: não é @RestController
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/alunos")
    public String listarAlunos(Model model) {
        model.addAttribute("alunos", alunoService.listarTodos());
        return "lista-alunos"; // Retorna o nome do arquivo HTML
    }

    @GetMapping("/alunos/novo")
    public String mostrarFormularioDeNovoAluno(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "form-aluno";
    }

    @PostMapping("/alunos/salvar")
    public String salvarAluno(Aluno aluno) {
        alunoService.salvar(aluno);
        return "redirect:/alunos";
    }

    @GetMapping("/alunos/editar/{id}")
    public String mostrarFormularioDeEdicao(@PathVariable Long id, Model model) {
        model.addAttribute("aluno", alunoService.buscarPorId(id));
        return "form-aluno";
    }

    @GetMapping("/alunos/deletar/{id}")
    public String deletarAluno(@PathVariable Long id) {
        alunoService.deletar(id);
        return "redirect:/alunos";
    }

    @GetMapping("/")
    public String mostrarPaginaInicial() {
    return "index"; // Retorna o nome do arquivo index.html
}
}