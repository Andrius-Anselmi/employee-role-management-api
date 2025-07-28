package dev.java.Gerenciamento.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome",  nullable = false)
    private String nome;

    @Column(name = "salario", nullable = false)
    private BigDecimal salario;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "nivel", nullable = false)
    private String nivel;

    @OneToMany(mappedBy = "cargo" )
    private List<Funcionario> funcionarios;


}


