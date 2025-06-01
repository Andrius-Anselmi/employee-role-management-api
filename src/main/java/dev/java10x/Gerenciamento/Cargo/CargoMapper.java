package dev.java10x.Gerenciamento.Cargo;

import dev.java10x.Gerenciamento.Funcionario.FuncionarioMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
    public class CargoMapper {

        private FuncionarioMapper funcionarioMapper;

        public CargoMapper(FuncionarioMapper funcionarioMapper) {
            this.funcionarioMapper = funcionarioMapper;
        }

        public CargoModel map(CargoDetalhadoDTO cargoDetalhadoDTO) {

            CargoModel cargoModel = new CargoModel();
            cargoModel.setId(cargoDetalhadoDTO.getId());
            cargoModel.setNome(cargoDetalhadoDTO.getNome());
            cargoModel.setDescricao(cargoDetalhadoDTO.getDescricao());
            cargoModel.setSalario(cargoDetalhadoDTO.getSalario());
            cargoModel.setNivel(cargoDetalhadoDTO.getNivel());
            cargoModel.setFuncionarios(cargoDetalhadoDTO.getFuncionarios().stream().map(funcionarioMapper::map).toList());

            return cargoModel;
        }

        public CargoDetalhadoDTO map(CargoModel cargoModel) {

            CargoDetalhadoDTO cargoDetalhadoDTO = new CargoDetalhadoDTO();
            cargoDetalhadoDTO.setId(cargoModel.getId());
            cargoDetalhadoDTO.setNome(cargoModel.getNome());
            cargoDetalhadoDTO.setDescricao(cargoModel.getDescricao());
            cargoDetalhadoDTO.setNivel(cargoModel.getNivel());
            cargoDetalhadoDTO.setSalario(cargoModel.getSalario());
            if (cargoModel.getFuncionarios() != null) {
                cargoDetalhadoDTO.setFuncionarios(cargoModel.getFuncionarios().stream().map(funcionarioMapper::map).toList());
            } else {
                cargoDetalhadoDTO.setFuncionarios(Collections.emptyList());
            }

            return cargoDetalhadoDTO;
        }

        public CargoResumoDTO mapResumo(CargoModel cargoModel) {
            CargoResumoDTO cargoResumoDTO = new CargoResumoDTO();
            cargoResumoDTO.setId(cargoModel.getId());
            cargoResumoDTO.setDescricao(cargoModel.getDescricao());
            cargoResumoDTO.setNivel(cargoModel.getNivel());
            cargoResumoDTO.setSalario(cargoModel.getSalario());

            return cargoResumoDTO;
        }

    }

