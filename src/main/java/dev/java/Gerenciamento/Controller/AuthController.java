package dev.java.Gerenciamento.Controller;

import dev.java.Gerenciamento.DTO.Request.UserRequest;
import dev.java.Gerenciamento.DTO.Response.UserResponse;
import dev.java.Gerenciamento.Mapper.UserMapper;
import dev.java.Gerenciamento.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final UserService userService;

    @PostMapping("/registrar")
    public ResponseEntity<UserResponse> registrar(@RequestBody UserRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).
                body(UserMapper.toUserResponse(userService.registrar(UserMapper.toUser(request))));
    }



}
