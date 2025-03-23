package dev.java10x.Gerenciamento.Funcionario;

import dev.java10x.Gerenciamento.Cargo.CargoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<FuncionarioRepository, Long> {
}
