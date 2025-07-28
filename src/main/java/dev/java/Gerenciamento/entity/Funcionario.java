package dev.java.Gerenciamento.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "idade")
    private int idade;

    @Column(name = "uf")
    private String uf;

    @Column(name = "cidade")
    private String cidade;


    @ManyToOne()
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;





}
