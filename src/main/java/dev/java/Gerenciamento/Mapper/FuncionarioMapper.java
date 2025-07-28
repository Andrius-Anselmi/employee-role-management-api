package dev.java.Gerenciamento.Mapper;


import dev.java.Gerenciamento.DTO.Request.FuncionarioRequest;
import dev.java.Gerenciamento.DTO.Response.FuncionarioResponse;
import dev.java.Gerenciamento.entity.Cargo;
import dev.java.Gerenciamento.entity.Funcionario;
import lombok.experimental.UtilityClass;

@UtilityClass

public class FuncionarioMapper {

    public static Cargo toCargoId(FuncionarioRequest request){
        return Cargo.builder()
                .id(request.cargo_id())
                .build();
    }


    public static Funcionario toFuncionario(FuncionarioRequest request){

        return Funcionario.builder()
                .nome(request.nome())
                .idade(request.idade())
                .uf(request.uf())
                .cidade(request.cidade())
                .cargo(toCargoId(request)).
                build();
    }

    public static FuncionarioResponse toResponse(Funcionario funcionario){
        return FuncionarioResponse.builder()
                .id(funcionario.getId())
                .nome(funcionario.getNome())
                .idade(funcionario.getIdade())
                .uf(funcionario.getUf())
                .cidade(funcionario.getCidade())
                .cargo(funcionario.getCargo()).
                build();
    }

    }






