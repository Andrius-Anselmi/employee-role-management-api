package dev.java10x.Gerenciamento.Repository;

import dev.java10x.Gerenciamento.Model.CargoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<CargoModel, Long> {
}
