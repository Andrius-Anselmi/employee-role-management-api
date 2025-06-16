package dev.java.Gerenciamento.Controller;
import dev.java.Gerenciamento.Model.CargoModel;
import dev.java.Gerenciamento.Service.CargoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cargo")

public class CargoController {

    private final CargoService cargoService;

    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    //CRIAR CARGO
    @PostMapping()
    public CargoModel cadastrarCargo(@RequestBody CargoModel cargoCriado) {
        return cargoService.cadastrarCargo(cargoCriado);
    }

    //EXIBIR CARGO
    @GetMapping()
    public List<CargoModel> exibirCargos() {
        return cargoService.exibirCargos();
    }

    //EXIBIR CARGO POR ID
    @GetMapping("{id}")
    public CargoModel exibirPorId(@PathVariable Long id) {
        if (cargoService.exibirPorId(id) != null) {
            return cargoService.exibirPorId(id);
        } else
            return null;
    }
    //DELETAR CARGO POR ID
    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id) {
        cargoService.deletar(id);
    }

    //ALTERAR CARGO POR ID
    @PutMapping("{id}")
    public CargoModel alterarCargo(@RequestBody CargoModel cargo, @PathVariable Long id) {
        if(cargoService.exibirPorId(id) != null){
            cargoService.alterarCargo(id,cargo);
        }
        return null;
}
        }

