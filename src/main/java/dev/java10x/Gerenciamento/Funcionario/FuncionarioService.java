package dev.java10x.Gerenciamento.Funcionario;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;
    private FuncionarioMapper funcionarioMapper;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, FuncionarioMapper funcionarioMapper) {
        this.funcionarioRepository = funcionarioRepository;
        this.funcionarioMapper = funcionarioMapper;
    }

    //CADASTRAR FUNCIONARIO
    public FuncionarioDTO criarFuncionario(FuncionarioDTO funcionarioDTO) {
        FuncionarioModel funcionario = funcionarioMapper.map(funcionarioDTO);
        funcionario = funcionarioRepository.save(funcionario);
        return funcionarioMapper.map(funcionario);
    }

    //EXIBIR FUNCIONARIOS
    public List<FuncionarioDTO> exibirFuncionarios() {
        List<FuncionarioModel> listaFuncionarios = funcionarioRepository.findAll();
        return listaFuncionarios.stream()
                .map(funcionarioMapper::map)
                .collect(Collectors.toList());
    }

    //EXIBIR FUNCIONARIO POR ID
    public FuncionarioDTO exibirFuncionariosPorId(Long id) {
        Optional<FuncionarioModel> funcionarioBuscado = funcionarioRepository.findById(id);
        return funcionarioBuscado.map(funcionarioMapper::map).orElse(null);
    }

    //DELETAR FUNCIONARIO POR ID
    public void deletarFuncionarioPorId(Long id) {
        funcionarioRepository.deleteById(id);


    }

    //ALTERAR FUNCIONARIO POR ID
    public FuncionarioDTO alterarFuncionarioPorId(Long id, FuncionarioDTO funcionarioDTO) {
        Optional<FuncionarioModel> funcionarioExistente = funcionarioRepository.findById(id);
        if(funcionarioExistente.isPresent()){
            FuncionarioModel funcionarioAtualizado = funcionarioMapper.map(funcionarioDTO);
            funcionarioAtualizado.setId(id);
            FuncionarioModel funcionarioSalvo = funcionarioRepository.save(funcionarioAtualizado);
            return funcionarioMapper.map(funcionarioSalvo);
        }
        return null;


    }


    }

