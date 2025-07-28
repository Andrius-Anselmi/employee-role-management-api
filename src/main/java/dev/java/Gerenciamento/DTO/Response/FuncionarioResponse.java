package dev.java.Gerenciamento.DTO.Response;

import dev.java.Gerenciamento.entity.Cargo;
import lombok.Builder;

@Builder
public record FuncionarioResponse(Long id,String nome, int idade, String uf, String cidade, Cargo cargo) {

}

