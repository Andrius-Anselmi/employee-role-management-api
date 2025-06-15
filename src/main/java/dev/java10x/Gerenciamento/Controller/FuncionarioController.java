package dev.java10x.Gerenciamento.Controller;
import dev.java10x.Gerenciamento.Model.FuncionarioModel;
import dev.java10x.Gerenciamento.Service.FuncionarioService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping()
    public FuncionarioModel criarFuncionario(@RequestBody FuncionarioModel funcionarioModel){
        return funcionarioService.criarFuncionario(funcionarioModel);
    }

    @GetMapping()
    public List<FuncionarioModel> exibirFuncionarios(){
        return funcionarioService.exibirFuncionarios();
    }

    @GetMapping("{id}")
    public FuncionarioModel exibirPorId(@PathVariable Long id){
        return funcionarioService.exibirFuncionariosPorId(id);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id){
        funcionarioService.deletarFuncionarioPorId(id);
    }


}


