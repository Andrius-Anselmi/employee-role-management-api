package dev.java.Gerenciamento.Service;

import dev.java.Gerenciamento.Repository.CargoRepository;
import dev.java.Gerenciamento.entity.Cargo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CargoService {

    private final CargoRepository cargoRepository;


    public Cargo salvar(Cargo cargo) {
        return cargoRepository.save(cargo);
    }
    
    public List<Cargo> exibirCargos() {
        return  cargoRepository.findAll();
    }

    public Optional<Cargo> exibirPorId(Long id) {
        return cargoRepository.findById(id);
    }

    public void deletar(Long id) {
        cargoRepository.deleteById(id);
    }

    public Optional<Cargo> alterarCargo(Long id, Cargo cargo) {
        Optional<Cargo> cargoOpt = cargoRepository.findById(id);
        if(cargoOpt.isPresent()){
            Cargo cargoSalvo = cargoOpt.get();
            cargoSalvo.setNome(cargo.getNome());
            cargoSalvo.setDescricao(cargo.getDescricao());
            cargoSalvo.setNivel(cargo.getNivel());
            cargoSalvo.setSalario(cargo.getSalario());
            cargoRepository.save(cargoSalvo);
            return Optional.of(cargoSalvo);

        }

        return Optional.empty();
    }
}
