package dev.java10x.Gerenciamento.Funcionario;

import dev.java10x.Gerenciamento.Cargo.CargoModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_funcionario")
public class FuncionarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String cidade;
    private CargoModel cargos;

    public FuncionarioModel() {
    }

    public FuncionarioModel(int idade, String nome, String cidade) {
        this.idade = idade;
        this.nome = nome;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
