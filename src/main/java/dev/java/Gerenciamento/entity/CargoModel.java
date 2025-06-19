package dev.java.Gerenciamento.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
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
    @OneToMany(mappedBy = "cargo")
    private List<Funcionario> funcionarios;


}


