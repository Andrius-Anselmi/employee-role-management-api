package dev.java10x.Gerenciamento.Service;

import dev.java10x.Gerenciamento.DTO.FuncionarioDTO;
import dev.java10x.Gerenciamento.DTO.FuncionarioResumidoDTO;
import dev.java10x.Gerenciamento.Mapper.FuncionarioMapper;
import dev.java10x.Gerenciamento.Model.FuncionarioModel;
import dev.java10x.Gerenciamento.Repository.FuncionarioRepository;
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


