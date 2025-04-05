package dev.java10x.Gerenciamento.Funcionario;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @GetMapping("/bemvindo")
    public String boasVindas() {
        return "Seja bem vindo";
    }

    //CADASTRAR FUNCIONARIO
    @PostMapping("/cadastro")
    public String cadastrarFuncionario() {

        return "Cadastrando funcionario";
    }
    //EXIBIR FUNCIONARIOS
    @GetMapping("/exibir")
    public String exibirFuncionarios() {

        return "Exibindo funcionarios";
    }

    //EXIBIR FUNCIONARIO POR ID
    @GetMapping("/exibir{id}")
    public String exibirPorId() {

        return "Exibindo por ID";
    }
    //ALTERAR FUNCIONARIO POR ID
    @PutMapping("/alterar/{id}")
    public String alterarFuncionario() {

        return "Alterando dados do funcionario";
    }
    //DELETAR FUNCIONARIO POR ID
    @DeleteMapping("/deletar{id}")
    public String deletarFuncionario() {

        return "Deletando funcionario";
    }
}
