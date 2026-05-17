package dev.java.management.controller;

import dev.java.management.request.LoginRequest;
import dev.java.management.request.UserRequest;
import dev.java.management.response.LoginResponse;
import dev.java.management.response.UserResponse;
import dev.java.management.mapper.UserMapper;
import dev.java.management.service.TokenService;
import dev.java.management.service.UserService;
import dev.java.management.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/registrar")
    public ResponseEntity<UserResponse> registrar(@RequestBody UserRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).
                body(UserMapper.toUserResponse(userService.registrar(UserMapper.toUser(request))));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){

        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        Authentication authentication = authenticationManager.authenticate(userAndPass);

        User user = (User) authentication.getPrincipal();

        String token = tokenService.generateToken(user);

        return ResponseEntity.ok(new LoginResponse(token));
    }



}
