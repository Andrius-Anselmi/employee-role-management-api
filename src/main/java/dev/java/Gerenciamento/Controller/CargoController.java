package dev.java.Gerenciamento.Controller;
import dev.java.Gerenciamento.DTO.Request.CargoRequest;
import dev.java.Gerenciamento.DTO.Response.CargoResponse;
import dev.java.Gerenciamento.Mapper.CargoMapper;
import dev.java.Gerenciamento.Service.CargoService;
import dev.java.Gerenciamento.entity.Cargo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/cargo")
@RequiredArgsConstructor
public class CargoController {

    private final CargoService cargoService;


    @PostMapping()
    public ResponseEntity<CargoResponse> salvar(@RequestBody CargoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).
                body(CargoMapper.toResponse(cargoService.salvar(CargoMapper.toCargo(request))));
    }

    @GetMapping()
    public ResponseEntity<List<CargoResponse>> listarTodos() {
        return ResponseEntity.ok(cargoService.exibirCargos().stream().map(CargoMapper::toResponse).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<CargoResponse> buscarPorId(@PathVariable Long id) {
        Optional<Cargo> cargoOpt = cargoService.exibirPorId(id);
        return cargoOpt.map(cargo -> ResponseEntity.ok(CargoMapper.toResponse(cargo))).
                orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        if(cargoService.exibirPorId(id).isPresent()) {
            cargoService.deletar(id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.noContent().build();
    }


    @PutMapping("{id}")
    public ResponseEntity<CargoResponse> alterarCargo(@RequestBody CargoRequest request, @PathVariable Long id) {
            return cargoService.alterarCargo(id,CargoMapper.toCargo(request)).map
                    ( cargo -> ResponseEntity.ok(CargoMapper.toResponse(cargo))).orElse(ResponseEntity.notFound().build());
}
        }

