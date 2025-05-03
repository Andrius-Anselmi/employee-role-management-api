package dev.java10x.Gerenciamento.Cargo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cargo")

public class CargoController {

    //CRIAR CARGO
    @PostMapping("cadastro")
    public String cadastrarCargo(){

        return "cargo criado";
    }
    //EXIBIR CARGO
    @GetMapping("exibir")
    public String exibirCargos(){

        return "exibindo cargos";
    }
    //EXIBIR CARGO POR ID
    @GetMapping("exibir/{id}")
    public String exibirPorId(){
        return "exibindo cargo de id";
    }

    //DELETAR CARGO POR ID
    @DeleteMapping("deletar/{id}")
    public String deletar(){
        return "deletando cargo x";
    }

    //ALTERAR CARGO POR ID
    @PutMapping("alterar/{id}")
    public String alterarCargo(){
        return "alterando cargo de id";
    }


}
