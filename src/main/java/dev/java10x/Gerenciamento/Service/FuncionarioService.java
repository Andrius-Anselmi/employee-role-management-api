package dev.java10x.Gerenciamento.Service;

import dev.java10x.Gerenciamento.Model.FuncionarioModel;
import dev.java10x.Gerenciamento.Repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;


    //CADASTRAR FUNCIONARIO
    public FuncionarioModel criarFuncionario(FuncionarioModel funcionarioDTO) {
        return funcionarioRepository.save(funcionarioDTO);
    }

    //EXIBIR FUNCIONARIOS
    public List<FuncionarioModel> exibirFuncionarios() {
        return funcionarioRepository.findAll();
    }

    //EXIBIR FUNCIONARIO POR ID
    public FuncionarioModel exibirFuncionariosPorId(Long id) {
        Optional<FuncionarioModel> funcionarioBuscado = funcionarioRepository.findById(id);
        if (funcionarioBuscado.isPresent()) {
            return funcionarioBuscado.get();

        } else
            return null;
    }

    //DELETAR FUNCIONARIO POR ID
    public void deletarFuncionarioPorId(Long id) {
        funcionarioRepository.deleteById(id);
    }

    //ALTERAR FUNCIONARIO POR ID
    public void alterarFuncionarioPorId(Long id, FuncionarioModel funcionarioDTO) {

        }

    }


