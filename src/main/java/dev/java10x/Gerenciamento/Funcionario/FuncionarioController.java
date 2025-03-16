package dev.java10x.Gerenciamento.Funcionario;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class FuncionarioController {

    @GetMapping("/bemvindo")
    public String boasVindas() {
        return "Seja bem vindo";
    }
}
