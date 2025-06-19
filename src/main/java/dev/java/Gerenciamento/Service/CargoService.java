package dev.java.Gerenciamento.Service;

import dev.java.Gerenciamento.entity.CargoModel;
import dev.java.Gerenciamento.Repository.CargoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CargoService {

    private final CargoRepository cargoRepository;

    //CRIAR CARGO

    public CargoModel cadastrarCargo(CargoModel cargoModel) {
        return cargoRepository.save(cargoModel);
    }

    //EXIBIR CARGOS

    public List<CargoModel> exibirCargos() {
        return cargoRepository.findAll();
    }

    //EXIBIR CARGO POR ID

    public CargoModel exibirPorId(Long id) {
        Optional<CargoModel> cargoBuscado = cargoRepository.findById(id);
        if (cargoBuscado.isPresent()) {
            return cargoBuscado.get();
        }
        return null;
    }

    //DELETAR CARGO POR ID

    public void deletar(Long id) {
        cargoRepository.deleteById(id);
    }

    //ALTERAR CARGO POR ID
    public void alterarCargo(Long id, CargoModel cargo) {

    }

}
