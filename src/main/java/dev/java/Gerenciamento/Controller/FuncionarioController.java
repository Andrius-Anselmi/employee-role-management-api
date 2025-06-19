package dev.java.Gerenciamento.Controller;

import dev.java.Gerenciamento.Controller.Request.FuncionarioRequest;
import dev.java.Gerenciamento.Controller.Response.FuncionarioResponse;
import dev.java.Gerenciamento.Mapper.FuncionarioMapper;
import dev.java.Gerenciamento.entity.Funcionario;
import dev.java.Gerenciamento.Service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @PostMapping()
    public FuncionarioResponse criarFuncionario(@RequestBody FuncionarioRequest request) {
        Funcionario funcionario = FuncionarioMapper.toModel(request);
        Funcionario funcionarioSalvo = funcionarioService.criarFuncionario(funcionario);
        return FuncionarioMapper.toResponse(funcionarioSalvo);
    }

    @GetMapping()
    public List<FuncionarioResponse> ListarFuncionarios() {
        List<Funcionario> funcionarios = funcionarioService.exibirFuncionarios();
        return funcionarios.stream().map(FuncionarioMapper::toResponse).toList();
    }

    @GetMapping("{id}")
    public FuncionarioResponse ListarPorId(@PathVariable Long id) {
        Optional<Funcionario> funcionarioOpt = funcionarioService.exibirFuncionariosPorId(id);
        return FuncionarioMapper.toResponse(funcionarioOpt.orElse(null));
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id) {
        funcionarioService.deletarFuncionarioPorId(id);
    }


}


