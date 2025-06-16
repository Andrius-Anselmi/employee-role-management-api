package dev.java.Gerenciamento.Controller;
import dev.java.Gerenciamento.DTO.FuncionarioDTO;
import dev.java.Gerenciamento.DTO.FuncionarioResumidoDTO;
import dev.java.Gerenciamento.Model.FuncionarioModel;
import dev.java.Gerenciamento.Service.FuncionarioService;
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
    public FuncionarioDTO criarFuncionario(@RequestBody FuncionarioModel funcionarioModel){
        return funcionarioService.criarFuncionario(funcionarioModel);
    }

    @GetMapping()
    public List<FuncionarioResumidoDTO> ListarFuncionarios(){
        return funcionarioService.exibirFuncionarios();
    }

    @GetMapping("{id}")
    public FuncionarioDTO ListarPorId(@PathVariable Long id){
        return funcionarioService.exibirFuncionariosPorId(id);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id){
        funcionarioService.deletarFuncionarioPorId(id);
    }


}


