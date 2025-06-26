package br.com.grupo_educacao.sistema.controller;

import br.com.grupo_educacao.sistema.model.SalaDeAula;
import br.com.grupo_educacao.sistema.service.SalaDeAulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.grupo_educacao.sistema.model.Aluno;
import br.com.grupo_educacao.sistema.model.Professor;
import br.com.grupo_educacao.sistema.service.AlunoService;
import br.com.grupo_educacao.sistema.service.ProfessorService;

@Controller
@RequestMapping("/salas") // URL base para salas de aula
public class SalaDeAulaController {

    @Autowired
    private SalaDeAulaService salaDeAulaService;

    @GetMapping
    public String listarSalas(Model model) {
        model.addAttribute("salas", salaDeAulaService.listarTodos());
        return "lista-salas";
    }

    @GetMapping("/novo")
    public String mostrarFormularioDeNovaSala(Model model) {
        model.addAttribute("sala", new SalaDeAula());
        return "form-sala";
    }

    @PostMapping("/salvar")
    public String salvarSala(SalaDeAula salaDeAula) {
        salaDeAulaService.salvar(salaDeAula);
        return "redirect:/salas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicao(@PathVariable Long id, Model model) {
        model.addAttribute("sala", salaDeAulaService.buscarPorId(id));
        return "form-sala";
    }

    @GetMapping("/deletar/{id}")
    public String deletarSala(@PathVariable Long id) {
        salaDeAulaService.deletar(id);
        return "redirect:/salas";
    }

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/{id}")
    public String verDetalhesDaSala(@PathVariable Long id, Model model) {
        SalaDeAula sala = salaDeAulaService.buscarPorId(id);
        if (sala != null) {
            model.addAttribute("sala", sala);
            // Passamos a lista de todos os professores para o formulário de vínculo
            model.addAttribute("todosOsProfessores", professorService.listarTodos());
            // Criamos um novo objeto Aluno para o formulário de adição
            model.addAttribute("novoAluno", new Aluno());
            return "detalhes-sala";
        }
        return "redirect:/salas"; // Se não encontrar a sala, volta para a lista
    }


@PostMapping("/{salaId}/vincular-professor")
public String vincularProfessor(@PathVariable Long salaId, @RequestParam(required = false) Long professorId) {
    // A anotação agora diz que o professorId NÃO é obrigatório.
    
    // Só executa a lógica se um ID de professor foi realmente enviado
    if (professorId != null) {
        SalaDeAula sala = salaDeAulaService.buscarPorId(salaId);
        Professor professor = professorService.buscarPorId(professorId);

        if (sala != null && professor != null) {
            sala.setProfessor(professor);
            salaDeAulaService.salvar(sala);
        }
    }
    
    // Se professorId for nulo, ele simplesmente pula o 'if' e recarrega a página.
    return "redirect:/salas/" + salaId; 
}

@PostMapping("/{salaId}/adicionar-aluno")
public String adicionarAlunoNaSala(@PathVariable Long salaId, Aluno novoAluno) {
    SalaDeAula sala = salaDeAulaService.buscarPorId(salaId);

    // Regra de negócio: só adiciona se a sala não estiver cheia
    if (sala != null && sala.getAlunos().size() < sala.getCapacidade()) {
        novoAluno.setSalaDeAula(sala);
        alunoService.salvar(novoAluno);
    }
    return "redirect:/salas/" + salaId;
}

}