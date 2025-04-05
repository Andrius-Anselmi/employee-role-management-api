package dev.java10x.Gerenciamento.Funcionario;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    //CADASTRAR FUNCIONARIO


    //EXIBIR FUNCIONARIOS
    public List<FuncionarioModel> exibirFuncionarios() {
        return funcionarioRepository.findAll();
    }

    //EXIBIR FUNCIONARIO POR ID
    public FuncionarioModel exibirFuncionariosPorId(Long id) {
        Optional<FuncionarioModel> funcionarioPorId = funcionarioRepository.findById(id);
        return funcionarioPorId.orElse(null);
    }
}
