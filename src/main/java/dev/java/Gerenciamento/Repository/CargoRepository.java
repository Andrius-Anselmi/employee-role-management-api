package dev.java.Gerenciamento.Repository;

import dev.java.Gerenciamento.Model.CargoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<CargoModel, Long> {
}
