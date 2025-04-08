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
    public FuncionarioModel criarFuncionario(FuncionarioModel funcionarioModel) {
        FuncionarioModel funcionarioCriado = funcionarioRepository.save(funcionarioModel);
        return funcionarioCriado;
    }
    //EXIBIR FUNCIONARIOS
    public List<FuncionarioModel> exibirFuncionarios() {
        return funcionarioRepository.findAll();
    }
    //EXIBIR FUNCIONARIO POR ID
    public FuncionarioModel exibirFuncionariosPorId(Long id) {
        Optional<FuncionarioModel> funcionarioPorId = funcionarioRepository.findById(id);
        return funcionarioPorId.orElse(null);
    }

    //DELETAR FUNCIONARIO POR ID
    public String deletarFuncionarioPorId(Long id) {
        funcionarioRepository.deleteById(id);
        return "Funcionario Deletado com sucesso";
    }

    //ALTERAR FUNCIONARIO POR ID
    public FuncionarioModel alterarFuncionarioPorId(Long id, FuncionarioModel funcionario) {
        if(funcionarioRepository.existsById(id)) {
            funcionario.setId(id);
            return funcionarioRepository.save(funcionario);
        }
        return null;

    }
}
