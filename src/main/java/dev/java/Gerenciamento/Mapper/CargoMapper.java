package dev.java.Gerenciamento.Mapper;

import dev.java.Gerenciamento.DTO.CargoResumidoDTO;
import dev.java.Gerenciamento.Model.CargoModel;
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
