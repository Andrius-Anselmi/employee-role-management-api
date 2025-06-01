package dev.java10x.Gerenciamento.Cargo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargo")

public class CargoController {

    private CargoService cargoService;

    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    //CRIAR CARGO
    @PostMapping("cadastro")
    public CargoDetalhadoDTO cadastrarCargo(@RequestBody CargoDetalhadoDTO cargoCriado) {
        return cargoService.cadastrarCargo(cargoCriado);
    }

    //EXIBIR CARGO
    @GetMapping("exibir")
    public List<CargoResumoDTO> exibirCargos() {
        return cargoService.exibirCargos();
    }

    //EXIBIR CARGO POR ID
    @GetMapping("exibir/{id}")
    public CargoDetalhadoDTO exibirPorId(@PathVariable Long id) {
        if (cargoService.exibirPorId(id) != null) {
            return cargoService.exibirPorId(id);
        } else
            return null;
    }
    //DELETAR CARGO POR ID
    @DeleteMapping("deletar/{id}")
    public void deletar(@PathVariable Long id) {
        cargoService.deletar(id);
    }

    //ALTERAR CARGO POR ID
    @PutMapping("alterar/{id}")
    public CargoDetalhadoDTO alterarCargo(@RequestBody CargoDetalhadoDTO cargo, @PathVariable Long id) {
        if(cargoService.exibirPorId(id) != null){
            cargoService.alterarCargo(id,cargo);
        }
        return null;
}
        }

