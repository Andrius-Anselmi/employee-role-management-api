package dev.java10x.Gerenciamento.Repository;

import dev.java10x.Gerenciamento.Model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {
}
