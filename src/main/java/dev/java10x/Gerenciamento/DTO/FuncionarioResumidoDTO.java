package dev.java10x.Gerenciamento.DTO;


import dev.java10x.Gerenciamento.Model.CargoModel;
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
