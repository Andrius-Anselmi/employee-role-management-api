package dev.java10x.Gerenciamento.Cargo;

import dev.java10x.Gerenciamento.Funcionario.FuncionarioModel;
import jakarta.persistence.*;

import java.util.List;

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

    public CargoModel() {
    }

    public CargoModel(String nome, double salario, String descricao, String nivel) {
        this.nome = nome;
        this.salario = salario;
        this.descricao = descricao;
        this.nivel = nivel;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
