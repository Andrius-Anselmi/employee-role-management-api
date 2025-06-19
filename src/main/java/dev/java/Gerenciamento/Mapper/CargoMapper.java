package dev.java.Gerenciamento.Mapper;

import dev.java.Gerenciamento.DTO.CargoDTO;
import dev.java.Gerenciamento.DTO.CargoResumidoDTO;
import dev.java.Gerenciamento.entity.CargoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class CargoMapper {
//
      public CargoResumidoDTO paraCargoResumidoDTO(CargoModel cargoModel) {
          CargoResumidoDTO cargoResumidoDTO = new CargoResumidoDTO();
          cargoResumidoDTO.setNome(cargoModel.getNome());
          cargoResumidoDTO.setDescricao(cargoModel.getDescricao());
          cargoResumidoDTO.setNivel(cargoModel.getNivel());
          return cargoResumidoDTO;
    }

    public CargoDTO paraCargoDTO(CargoModel cargoModel) {
          CargoDTO cargoDTO = new CargoDTO();
          cargoDTO.setNome(cargoModel.getNome());
          cargoDTO.setSalario(cargoModel.getSalario());
          cargoDTO.setDescricao(cargoModel.getDescricao());
          cargoDTO.setNivel(cargoModel.getNivel());
          return cargoDTO;
    }
    }

