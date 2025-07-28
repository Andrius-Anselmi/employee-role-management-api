package dev.java.Gerenciamento.Service;

import dev.java.Gerenciamento.entity.Cargo;
import dev.java.Gerenciamento.entity.Funcionario;
import dev.java.Gerenciamento.Repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final CargoService cargoService;

    public Funcionario salvar(Funcionario funcionario) {
        Cargo cargo = verificarCargo(funcionario.getId());
        funcionario.setCargo(cargo);
        return funcionarioRepository.save(funcionario);
    }
    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> buscarFuncionarioPorId(Long id) {
        return funcionarioRepository.findById(id);
    }

    public void deletarFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }

    public Optional<Funcionario> alterarFuncionario(Long id, Funcionario funcionario) {
        Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(id);
        if (optionalFuncionario.isPresent()) {
            Funcionario funcionarioSalvo = optionalFuncionario.get();
            funcionarioSalvo.setNome(funcionario.getNome());
            funcionarioSalvo.setIdade(funcionario.getIdade());
            funcionarioSalvo.setUf(funcionario.getUf());
            funcionarioSalvo.setCidade(funcionario.getCidade());

            Cargo cargo = verificarCargo(funcionarioSalvo.getCargo().getId());
            funcionarioSalvo.setCargo(funcionario.getCargo());

            funcionarioRepository.save(funcionarioSalvo);
            return Optional.of(funcionarioSalvo);
        }

        return Optional.empty();
    }

    private Cargo verificarCargo(Long id){
        Optional<Cargo> cargoOpt = cargoService.exibirPorId(id);
        if (cargoOpt.isPresent()) {
            return cargoOpt.get();
        } else {
            throw new RuntimeException("Cargo não encontrado com o ID: " + id);
        }
    }
}



