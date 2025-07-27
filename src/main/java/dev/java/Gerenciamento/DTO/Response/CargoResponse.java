package dev.java.Gerenciamento.DTO.Response;


import lombok.Builder;

import java.math.BigDecimal;
@Builder
public record CargoResponse(Long id, String nome, String descricao, BigDecimal salario, String nivel){
}
