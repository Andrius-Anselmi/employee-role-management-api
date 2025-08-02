package dev.java.Gerenciamento.Mapper;

import dev.java.Gerenciamento.DTO.Request.UserRequest;
import dev.java.Gerenciamento.DTO.Response.UserResponse;
import dev.java.Gerenciamento.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUser (UserRequest request){
        return User.builder()
                .nome(request.nome())
                .email(request.email())
                .senha(request.senha())
                .build();
    }

    public static UserResponse toUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }
}


