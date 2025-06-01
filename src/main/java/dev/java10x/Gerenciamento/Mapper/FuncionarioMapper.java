package dev.java10x.Gerenciamento.Mapper;

import dev.java10x.Gerenciamento.DTO.FuncionarioDTO;
import dev.java10x.Gerenciamento.Model.FuncionarioModel;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

    public FuncionarioModel map(FuncionarioDTO funcionarioDTO) {

        FuncionarioModel funcionarioModel = new FuncionarioModel();
        funcionarioModel.setId(funcionarioDTO.getId());
        funcionarioModel.setNome(funcionarioDTO.getNome());
        funcionarioModel.setIdade(funcionarioDTO.getIdade());
        funcionarioModel.setCidade(funcionarioDTO.getCidade());
        funcionarioModel.setCargo(funcionarioDTO.getCargos());
        funcionarioModel.setUf(funcionarioDTO.getUf());

        return funcionarioModel;
    }

    public FuncionarioDTO map(FuncionarioModel funcionarioModel) {
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        funcionarioDTO.setId(funcionarioModel.getId());
        funcionarioDTO.setNome(funcionarioModel.getNome());
        funcionarioDTO.setIdade(funcionarioModel.getIdade());
        funcionarioDTO.setCidade(funcionarioModel.getCidade());
        funcionarioDTO.setCargos(funcionarioModel.getCargo());
        funcionarioDTO.setUf(funcionarioModel.getUf());

        return funcionarioDTO;
    }
}
