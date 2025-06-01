package dev.java10x.Gerenciamento.DTO;
import dev.java10x.Gerenciamento.Model.CargoModel;
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
