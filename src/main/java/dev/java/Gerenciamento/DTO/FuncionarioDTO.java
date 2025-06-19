package dev.java.Gerenciamento.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class FuncionarioDTO {

    private Long id;
    private String nome;
    private int idade;
    private String uf;
    private String cidade;
    private CargoDTO cargo;
}
