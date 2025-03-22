package dev.java10x.Gerenciamento.Cargo;

import dev.java10x.Gerenciamento.Funcionario.FuncionarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_cargos")
public class CargoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double salario;
    private String descricao;
    private String nivel;

    //@OneToMany - UM CARGO PODE TER VARIOS FUNCIONARIOS
    @OneToMany(mappedBy = "cargos")
    private List<FuncionarioModel> funcionarios;


}


