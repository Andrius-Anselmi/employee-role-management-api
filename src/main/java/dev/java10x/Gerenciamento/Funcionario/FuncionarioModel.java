package dev.java10x.Gerenciamento.Funcionario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.Gerenciamento.Cargo.CargoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString(exclude = "cargos")
@Table(name = "tb_funcionario")
public class FuncionarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "IDADE")
    private int idade;

    @Column(name = "UF")
    private String uf;

    @Column(name = "CIDADE")
    private String cidade;


    //@ManyToOne - MUITOS FUNCIONARIOS PODEM TER UM UNICO CARGO
    @JoinColumn(name = "cargo_id") //Foreing Key ou chave estrangeira
    @ManyToOne
    private CargoModel cargos;
}
