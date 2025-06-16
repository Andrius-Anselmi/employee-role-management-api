package dev.java.Gerenciamento.Repository;

import dev.java.Gerenciamento.Model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {
}
