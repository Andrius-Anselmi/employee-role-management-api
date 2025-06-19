package dev.java.Gerenciamento.Mapper;

import dev.java.Gerenciamento.Controller.Request.FuncionarioRequest;
import dev.java.Gerenciamento.Controller.Response.FuncionarioResponse;
import dev.java.Gerenciamento.entity.Funcionario;
import lombok.experimental.UtilityClass;
@UtilityClass

public class FuncionarioMapper {

    public static FuncionarioResponse toResponse(Funcionario response) {
        return FuncionarioResponse.builder().
                id(response.getId()).
                nome(response.getNome()).
                idade(response.getIdade()).
                build();
    }

    public static Funcionario toModel(FuncionarioRequest request) {
        return Funcionario.builder().
                id(request.id()).
                nome(request.nome()).
                idade(request.idade()).
                uf(request.uf()).
                cidade(request.cidade()).
                cargo(request.cargo()).
                build();
    }

    }







