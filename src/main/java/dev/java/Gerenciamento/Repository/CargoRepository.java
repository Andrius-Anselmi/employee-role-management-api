package dev.java.Gerenciamento.Repository;

import dev.java.Gerenciamento.entity.CargoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<CargoModel, Long> {
}
