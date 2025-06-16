package dev.java10x.Gerenciamento.Mapper;

import dev.java10x.Gerenciamento.DTO.CargoResumidoDTO;
import dev.java10x.Gerenciamento.Model.CargoModel;
import org.springframework.stereotype.Component;

@Component
public class CargoMapper {

    public CargoResumidoDTO paraCargoResumidoDTO(CargoModel cargoModel) {
        CargoResumidoDTO cargoResumidoDTO = new CargoResumidoDTO();
        cargoResumidoDTO.setNome(cargoModel.getNome());
        cargoResumidoDTO.setDescricao(cargoModel.getDescricao());
        cargoResumidoDTO.setNivel(cargoModel.getNivel());
        return cargoResumidoDTO;
    }

}
