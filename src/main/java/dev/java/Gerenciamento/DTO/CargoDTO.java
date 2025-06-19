package dev.java.Gerenciamento.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CargoDTO {

    private String nome;
    private String descricao;
    private double salario;
    private String nivel;

}
