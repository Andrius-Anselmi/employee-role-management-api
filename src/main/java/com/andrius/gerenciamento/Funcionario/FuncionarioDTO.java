package com.andrius.gerenciamento.Funcionario;
import com.andrius.gerenciamento.Cargo.CargoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FuncionarioDTO {

        private Long id;
        private String nome;
        private int idade;
        private String cidade;
        private String uf;
        private CargoModel cargos;

}
