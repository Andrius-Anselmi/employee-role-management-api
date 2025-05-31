package com.andrius.gerenciamento.Cargo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;
@Service
public class CargoService {

    private final CargoRepository cargoRepository;

    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    //CRIAR CARGO
    @PostMapping("cadastro")
    public CargoModel cadastrarCargo(CargoModel cargo){
        CargoModel cargoCriado = cargoRepository.save(cargo);
        return cargoCriado;
    }
    //EXIBIR CARGOS
    @GetMapping("exibir")
    public List<CargoModel> exibirCargos(){
        return  cargoRepository.findAll();
    }
    //EXIBIR CARGO POR ID
    @GetMapping("exibir/{id}")
    public CargoModel exibirPorId(Long id){
        Optional<CargoModel> cargoBuscado = cargoRepository.findById(id);
        return cargoBuscado.orElse(null);// ou retorna o cargo ou retorna null
    }

    //DELETAR CARGO POR ID
    @DeleteMapping("deletar/{id}")
    public void deletar(Long id){
        cargoRepository.deleteById(id);
    }

    //ALTERAR CARGO POR ID
    @PutMapping("alterar/{id}")
    public String alterarCargo(){
        return "alterando cargo de id";
    }


}
