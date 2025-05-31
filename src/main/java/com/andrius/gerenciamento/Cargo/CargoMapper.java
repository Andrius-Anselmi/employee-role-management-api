package com.andrius.gerenciamento.Cargo;

import com.andrius.gerenciamento.Funcionario.FuncionarioDTO;
import com.andrius.gerenciamento.Funcionario.FuncionarioMapper;
import com.andrius.gerenciamento.Funcionario.FuncionarioModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CargoMapper {

    private FuncionarioMapper funcionarioMapper;

    public CargoMapper(FuncionarioMapper funcionarioMapper) {
        this.funcionarioMapper = funcionarioMapper;
    }

    public  CargoModel map(CargoDTO cargoDTO) {

        CargoModel cargoModel = new CargoModel();
        cargoModel.setId(cargoDTO.getId());
        cargoModel.setNome(cargoDTO.getNome());
        cargoModel.setDescricao(cargoDTO.getDescricao());
        cargoModel.setSalario(cargoDTO.getSalario());
        cargoModel.setNivel(cargoDTO.getNivel());
        cargoModel.setFuncionarios(cargoDTO.getFuncionarios().stream().map(funcionarioMapper::map).toList());

        return cargoModel;
    }

    public CargoDTO map(CargoModel cargoModel) {

        CargoDTO cargoDTO = new CargoDTO();
        cargoDTO.setId(cargoModel.getId());
        cargoDTO.setNome(cargoModel.getNome());
        cargoDTO.setDescricao(cargoModel.getDescricao());
        cargoDTO.setNivel(cargoDTO.getDescricao());
        cargoDTO.setSalario(cargoDTO.getSalario());
        cargoDTO.setFuncionarios(cargoModel.getFuncionarios().stream().map(funcionarioMapper::map).toList());

        return cargoDTO;
    }
}
