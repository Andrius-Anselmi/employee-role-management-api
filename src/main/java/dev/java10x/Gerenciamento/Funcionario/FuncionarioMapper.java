package dev.java10x.Gerenciamento.Funcionario;

import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

    public FuncionarioModel map(FuncionarioDTO funcionarioDTO) {

        FuncionarioModel funcionarioModel = new FuncionarioModel();
        funcionarioModel.setId(funcionarioDTO.getId());
        funcionarioModel.setNome(funcionarioDTO.getNome());
        funcionarioModel.setIdade(funcionarioDTO.getIdade());
        funcionarioModel.setCidade(funcionarioDTO.getCidade());
        funcionarioModel.setCargos(funcionarioDTO.getCargos());
        funcionarioModel.setUf(funcionarioDTO.getUf());

        return funcionarioModel;
    }

    public FuncionarioDTO map(FuncionarioModel funcionarioModel) {
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        funcionarioDTO.setId(funcionarioModel.getId());
        funcionarioDTO.setNome(funcionarioModel.getNome());
        funcionarioDTO.setIdade(funcionarioModel.getIdade());
        funcionarioDTO.setCidade(funcionarioModel.getCidade());
        funcionarioDTO.setCargos(funcionarioModel.getCargos());
        funcionarioDTO.setUf(funcionarioModel.getUf());

        return funcionarioDTO;
    }
}
