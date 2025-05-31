package com.andrius.gerenciamento.Cargo;

import com.andrius.gerenciamento.Funcionario.FuncionarioDTO;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class CargoDTO {

    private Long id;
    private String nome;
    private double salario;
    private String descricao;
    private String nivel;
    private List<FuncionarioDTO> funcionarios;

}
