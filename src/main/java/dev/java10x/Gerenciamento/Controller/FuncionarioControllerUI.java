package dev.java10x.Gerenciamento.Controller;


import dev.java10x.Gerenciamento.DTO.FuncionarioDTO;
import dev.java10x.Gerenciamento.Service.FuncionarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("funcionario/ui")

public class FuncionarioControllerUI {

    private final FuncionarioService funcionarioService;

    public FuncionarioControllerUI(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("listar")
    public String listarNinjas(Model model) {
        List<FuncionarioDTO> funcionarios = funcionarioService.exibirFuncionarios();
        model.addAttribute("funcionarios", funcionarios);
        return "funcionarios";
    }
}
