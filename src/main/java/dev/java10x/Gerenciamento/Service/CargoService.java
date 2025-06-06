package dev.java10x.Gerenciamento.Service;

import dev.java10x.Gerenciamento.DTO.CargoDetalhadoDTO;
import dev.java10x.Gerenciamento.DTO.CargoResumoDTO;
import dev.java10x.Gerenciamento.Mapper.CargoMapper;
import dev.java10x.Gerenciamento.Model.CargoModel;
import dev.java10x.Gerenciamento.Repository.CargoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService {

    private CargoRepository cargoRepository;
    private CargoMapper cargoMapper;

    public CargoService(CargoRepository cargoRepository, CargoMapper cargoMapper) {
        this.cargoRepository = cargoRepository;
        this.cargoMapper = cargoMapper;
    }

    //CRIAR CARGO
    @PostMapping("cadastro")
    public CargoDetalhadoDTO cadastrarCargo(CargoDetalhadoDTO cargoDetalhadoDTO){
        CargoModel cargoSalvo = cargoMapper.map(cargoDetalhadoDTO);
        cargoSalvo = cargoRepository.save(cargoSalvo);
        return cargoMapper.map(cargoSalvo);
    }

    //EXIBIR CARGOS
    @GetMapping("exibir")
    public List<CargoResumoDTO> exibirCargos(){
        List<CargoModel> listaDeCargos  = cargoRepository.findAll();
        return listaDeCargos.stream().map(cargoModel -> cargoMapper.mapResumo(cargoModel)).toList();
    }

    //EXIBIR CARGO POR ID
    @GetMapping("exibir/{id}")
    public CargoDetalhadoDTO exibirPorId(Long id){
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
    public CargoDetalhadoDTO alterarCargo(Long id, CargoDetalhadoDTO cargo){
        Optional<CargoModel> cargoExistente = cargoRepository.findById(id);
        if(cargoExistente.isPresent()){
            CargoModel cargoAtualizado = cargoMapper.map(cargo);
            cargo.setId(id);
            CargoModel cargoSalvo = cargoRepository.save(cargoAtualizado);
            return cargoMapper.map(cargoSalvo);
        }

        return null;
    }

}
