package dev.java10x.Gerenciamento.Cargo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SALARIO")
    private double salario;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "NIVEL")
    private String nivel;

    //@OneToMany - UM CARGO PODE TER VARIOS FUNCIONARIOS
    @JsonIgnore
    @OneToMany(mappedBy = "cargos")
    private List<FuncionarioModel> funcionarios;


}


