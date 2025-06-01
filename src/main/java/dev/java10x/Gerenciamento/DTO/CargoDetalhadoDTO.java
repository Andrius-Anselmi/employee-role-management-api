package dev.java10x.Gerenciamento.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class CargoDetalhadoDTO {

    private Long id;
    private String nome;
    private double salario;
    private String descricao;
    private String nivel;
    private List<FuncionarioDTO> funcionarios;

}
