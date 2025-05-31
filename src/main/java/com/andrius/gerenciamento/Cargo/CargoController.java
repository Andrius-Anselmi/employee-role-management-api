package com.andrius.gerenciamento.Cargo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargo")

public class CargoController {

    private final CargoService cargoService;

    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    //CRIAR CARGO
    @PostMapping("cadastro")
    public CargoModel cadastrarCargo(@RequestBody CargoModel cargoCriado){
        return cargoService.cadastrarCargo(cargoCriado);
    }
    //EXIBIR CARGO
    @GetMapping("exibir")
    public List<CargoModel> exibirCargos(){
        return  cargoService.exibirCargos();
    }
    //EXIBIR CARGO POR ID
    @GetMapping("exibir/{id}")
    public CargoModel exibirPorId(@PathVariable Long id){
        return cargoService.exibirPorId(id);
    }

    //DELETAR CARGO POR ID
    @DeleteMapping("deletar/{id}")
    public void deletar(@PathVariable Long id){
        cargoService.deletar(id);
    }

    //ALTERAR CARGO POR ID
    @PutMapping("alterar/{id}")
    public String alterarCargo(){
        return "alterando cargo de id";
    }


}
