package dev.java.Gerenciamento.Repository;

import dev.java.Gerenciamento.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
