package dev.java.Gerenciamento.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioResumidoDTO {

    private String nome;
    private int idade;
    private CargoResumidoDTO cargo;



}
