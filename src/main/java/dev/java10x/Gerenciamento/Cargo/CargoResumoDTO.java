package dev.java10x.Gerenciamento.Cargo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CargoResumoDTO {
    private Long id;
    private String nome;
    private double salario;
    private String descricao;
    private String nivel;

}
