package dev.java.Gerenciamento.Controller.Response;

import lombok.Builder;

@Builder
public record FuncionarioResponse (Long id,String nome, int idade) {
}
