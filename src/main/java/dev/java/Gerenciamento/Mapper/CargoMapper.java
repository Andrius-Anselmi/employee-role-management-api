package dev.java.Gerenciamento.Mapper;

import dev.java.Gerenciamento.DTO.Request.CargoRequest;
import dev.java.Gerenciamento.DTO.Response.CargoResponse;
import dev.java.Gerenciamento.entity.Cargo;
import lombok.experimental.UtilityClass;

@UtilityClass

public class CargoMapper {

    public static Cargo toCargo(CargoRequest request){
        return Cargo.builder()
                .nome(request.nome())
                .descricao(request.descricao())
                .salario(request.salario())
                .nivel(request.nivel()).
                build();
    }

    public static CargoResponse toResponse(Cargo cargo){
        return CargoResponse.builder()
                .id(cargo.getId())
                .nome(cargo.getNome())
                .descricao(cargo.getDescricao())
                .salario(cargo.getSalario())
                .nivel(cargo.getNivel()).
                build();
    }

    }

