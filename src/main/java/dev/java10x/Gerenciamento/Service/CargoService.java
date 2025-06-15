package dev.java10x.Gerenciamento.Service;

import dev.java10x.Gerenciamento.Model.CargoModel;
import dev.java10x.Gerenciamento.Repository.CargoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
