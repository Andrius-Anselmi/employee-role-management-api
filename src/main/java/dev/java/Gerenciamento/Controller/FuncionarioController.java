package dev.java.Gerenciamento.Controller;

import dev.java.Gerenciamento.DTO.Request.FuncionarioRequest;
import dev.java.Gerenciamento.DTO.Response.FuncionarioResponse;
import dev.java.Gerenciamento.Mapper.FuncionarioMapper;
import dev.java.Gerenciamento.Service.FuncionarioService;
import dev.java.Gerenciamento.entity.Funcionario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @PostMapping()
    public ResponseEntity<FuncionarioResponse> salvar(@RequestBody FuncionarioRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).
                body(FuncionarioMapper.toResponse(funcionarioService.salvar(FuncionarioMapper.toFuncionario(request))));
    }

    @GetMapping()
    public ResponseEntity<List<FuncionarioResponse>> listar() {
        return ResponseEntity.ok(funcionarioService.listarFuncionarios().
                stream().map(FuncionarioMapper::toResponse).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponse> bucarPorId(@PathVariable Long id) {
        return funcionarioService.buscarFuncionarioPorId(id).map
                        (funcionario -> ResponseEntity.ok(FuncionarioMapper.toResponse(funcionario)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioResponse> alterar(@PathVariable Long id, FuncionarioRequest request) {
        return funcionarioService.alterarFuncionario(id, FuncionarioMapper.toFuncionario(request))
                .map(funcionario -> ResponseEntity.ok(FuncionarioMapper.toResponse(funcionario)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Funcionario> Optfuncionario = funcionarioService.buscarFuncionarioPorId(id);
        if (Optfuncionario.isPresent()) {
            funcionarioService.deletarFuncionario(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}




