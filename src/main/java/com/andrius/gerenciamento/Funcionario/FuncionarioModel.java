package com.andrius.gerenciamento.Funcionario;

import com.andrius.gerenciamento.Cargo.CargoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
