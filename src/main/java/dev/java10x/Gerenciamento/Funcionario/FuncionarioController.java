package dev.java10x.Gerenciamento.Funcionario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/bemvindo")
    public String boasVindas() {
        return "Seja bem vindo";
    }

    //CADASTRAR FUNCIONARIO
    @PostMapping("/cadastro")
    public ResponseEntity<String> criarFuncionario(@RequestBody FuncionarioDTO funcionario) {
        funcionarioService.criarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Funcionario criado com sucesso: " + funcionario.getNome());
    }

    //EXIBIR FUNCIONARIOS
    @GetMapping("/exibir")
    public ResponseEntity<List<FuncionarioDTO>> exibirFuncionarios() {
        List<FuncionarioDTO> listaFuncionarios =  funcionarioService.exibirFuncionarios();
        return ResponseEntity.ok(listaFuncionarios);
    }

    //EXIBIR FUNCIONARIO POR ID
    @GetMapping("/exibir/{id}")
    public ResponseEntity<?> exibirFuncionarioPorId(@PathVariable Long id) {
            FuncionarioDTO funcionarioDTO = funcionarioService.exibirFuncionariosPorId(id);
            if(funcionarioDTO != null){
                return ResponseEntity.ok(funcionarioDTO);
            }else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).
                        body("Funcionario de id " + id + " não existe");
    }

    //DELETAR FUNCIONARIO POR ID
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarFuncionario(@PathVariable Long id) {
     if(funcionarioService.exibirFuncionariosPorId(id) != null){
         funcionarioService.deletarFuncionarioPorId(id);
         return ResponseEntity.status(HttpStatus.OK).body("Funcionario com o id " + id + " deletado com sucesso");
     }else
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario não foi deletado, pois não foi possivel encontrado)");

    }
    //ALTERAR FUNCIONARIO POR ID
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarFuncionario(@PathVariable Long id, @RequestBody FuncionarioDTO funcionario) {
        if ((funcionarioService.exibirFuncionariosPorId(id) != null)) {
            FuncionarioDTO funcionarioDTO = funcionarioService.alterarFuncionarioPorId(id, funcionario);
            return ResponseEntity.ok(funcionarioDTO);
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario não foi alterado, pois não foi possivel encontrado");

    }


}
