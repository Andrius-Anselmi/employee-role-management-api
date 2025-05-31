package dev.java10x.Gerenciamento.Cargo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CargoService {

    private final CargoRepository cargoRepository;
    private CargoMapper cargoMapper;

    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public CargoService(CargoRepository cargoRepository, CargoMapper cargoMapper) {
        this.cargoRepository = cargoRepository;
        this.cargoMapper = cargoMapper;
    }

    //CRIAR CARGO
    @PostMapping("cadastro")
    public CargoDTO cadastrarCargo(CargoDTO cargoDTO){
        CargoModel cargoSalvo = cargoMapper.map(cargoDTO);
        cargoSalvo = cargoRepository.save(cargoSalvo);
        return cargoMapper.map(cargoSalvo);
    }

    //EXIBIR CARGOS
    @GetMapping("exibir")
    public List<CargoDTO> exibirCargos(){
        List<CargoModel> listaDeCargos  = cargoRepository.findAll();
        return listaDeCargos.stream()
                .map(cargoMapper::map).collect(Collectors.toList());
    }

    //EXIBIR CARGO POR ID
    @GetMapping("exibir/{id}")
    public CargoDTO exibirPorId(Long id){
        Optional<CargoModel> cargoBuscado = cargoRepository.findById(id);
        return cargoBuscado.map(cargoMapper::map).orElse(null);
    }

    //DELETAR CARGO POR ID
    @DeleteMapping("deletar/{id}")
    public void deletar(Long id){
        cargoRepository.deleteById(id);
    }

    //ALTERAR CARGO POR ID
    @PutMapping("alterar/{id}")
    public CargoDTO alterarCargo(Long id, CargoDTO cargo){
        Optional<CargoModel> cargoExistente = cargoRepository.findById(id);
        if(cargoExistente.isPresent()){
            CargoModel cargoAtualizado = cargoMapper.map(cargo);
            cargo.setId(id);
            CargoModel cargoSalvo = cargoRepository.save(cargoAtualizado);
            return  cargoMapper.map(cargoSalvo);
        }

        return null;
    }

}
