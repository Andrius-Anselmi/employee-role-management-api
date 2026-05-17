package dev.java.management.entity;

import dev.java.management.enums.Seniority;
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
@Table(name = "positions")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title",  nullable = false)
    private String title;

    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

    @Column(name = "description")
    private String description;

    @Column(name = "seniority", nullable = false)
    @Enumerated(EnumType.STRING)
    private Seniority seniority;

    @OneToMany(mappedBy = "position" )
    private List<Employee> employees;


}


