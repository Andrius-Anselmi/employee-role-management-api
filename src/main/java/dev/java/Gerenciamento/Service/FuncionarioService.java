package dev.java.Gerenciamento.Service;

import dev.java.Gerenciamento.DTO.FuncionarioDTO;
import dev.java.Gerenciamento.DTO.FuncionarioResumidoDTO;
import dev.java.Gerenciamento.Mapper.FuncionarioMapper;
import dev.java.Gerenciamento.Model.FuncionarioModel;
import dev.java.Gerenciamento.Repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioMapper funcionarioMapper;

    public FuncionarioDTO criarFuncionario(FuncionarioModel funcionarioModel) {
        FuncionarioModel funcionsarioSalvo = funcionarioRepository.save(funcionarioModel);
        return funcionarioMapper.mapParaFuncionarioDTO(funcionsarioSalvo);
    }

    public List<FuncionarioResumidoDTO> exibirFuncionarios() {
        List<FuncionarioModel> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream().map(funcionarioMapper::mapParaFuncionarioResumidoDTO).collect(toList());
    }

    public FuncionarioDTO exibirFuncionariosPorId(Long id) {
        Optional<FuncionarioModel> funcionarioModel = funcionarioRepository.findById(id);
        if(funcionarioModel.isPresent()){
            return funcionarioMapper.mapParaFuncionarioDTO(funcionarioModel.get());
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


