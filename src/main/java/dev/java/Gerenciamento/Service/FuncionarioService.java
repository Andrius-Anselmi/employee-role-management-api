package dev.java.Gerenciamento.Service;

import dev.java.Gerenciamento.Mapper.FuncionarioMapper;
import dev.java.Gerenciamento.entity.Funcionario;
import dev.java.Gerenciamento.Repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public Funcionario criarFuncionario(Funcionario funcionarioModel) {
        return funcionarioRepository.save(funcionarioModel);

    }

    public List<Funcionario> exibirFuncionarios() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream().toList();
    }

    public Optional<Funcionario> exibirFuncionariosPorId(Long id) {
        Optional<Funcionario> funcionarioModel = funcionarioRepository.findById(id);
        if (funcionarioModel.isPresent()) {
            return funcionarioModel;
        }
        return Optional.empty();
    }


    public void deletarFuncionarioPorId(Long id) {
        funcionarioRepository.deleteById(id);
    }

//     FUNCIONARIO POR ID
//    public void alterarFuncionarioPorId(Long id, FuncionarioModel funcionarioDTO) {
//
//        }

    }


