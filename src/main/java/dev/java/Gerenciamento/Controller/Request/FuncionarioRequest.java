package dev.java.Gerenciamento.Controller.Request;

import dev.java.Gerenciamento.entity.CargoModel;
import lombok.Builder;


@Builder
public record FuncionarioRequest (Long id, String nome, int idade, String uf, String cidade, CargoModel cargo){

}
