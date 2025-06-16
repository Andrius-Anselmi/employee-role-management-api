package dev.java10x.Gerenciamento.Mapper;

import dev.java10x.Gerenciamento.DTO.FuncionarioDTO;
import dev.java10x.Gerenciamento.DTO.FuncionarioResumidoDTO;
import dev.java10x.Gerenciamento.Model.FuncionarioModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class FuncionarioMapper {

    private final CargoMapper cargoMapper;

    public FuncionarioModel mapParaFuncionarioModel(FuncionarioDTO funcionarioDTO) {
        FuncionarioModel funcionarioModel = new FuncionarioModel();
        funcionarioModel.setId(funcionarioDTO.getId());
        funcionarioModel.setNome(funcionarioDTO.getNome());
        funcionarioModel.setIdade(funcionarioDTO.getIdade());
        funcionarioModel.setUf(funcionarioDTO.getUf());
        funcionarioModel.setCidade(funcionarioDTO.getCidade());
        funcionarioModel.setCargo(funcionarioDTO.getCargo());
        return funcionarioModel;
    }

    public FuncionarioDTO mapParaFuncionarioDTO(FuncionarioModel funcionarioModel) {
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        funcionarioDTO.setId(funcionarioModel.getId());
        funcionarioDTO.setNome(funcionarioModel.getNome());
        funcionarioDTO.setIdade(funcionarioModel.getIdade());
        funcionarioDTO.setUf(funcionarioModel.getUf());
        funcionarioDTO.setCidade(funcionarioModel.getCidade());
        funcionarioDTO.setCargo(funcionarioModel.getCargo());
        return funcionarioDTO;

    }

    public FuncionarioResumidoDTO mapParaFuncionarioResumidoDTO(FuncionarioModel funcionarioModel) {
        FuncionarioResumidoDTO funcionarioResumidoDTO = new FuncionarioResumidoDTO();
        funcionarioResumidoDTO.setNome(funcionarioModel.getNome());
        funcionarioResumidoDTO.setIdade(funcionarioModel.getIdade());
        funcionarioResumidoDTO.setCargo(cargoMapper.paraCargoResumidoDTO(funcionarioModel.getCargo()));
        return funcionarioResumidoDTO;
    }
    }

