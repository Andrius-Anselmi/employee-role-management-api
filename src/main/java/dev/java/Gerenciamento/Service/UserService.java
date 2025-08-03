package dev.java.Gerenciamento.Service;

import dev.java.Gerenciamento.Repository.UserRepository;
import dev.java.Gerenciamento.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder encoder;

    private final UserRepository userRepository;

    public User registrar(User user){
        String senha = user.getSenha();
        user.setSenha(encoder.encode(senha));
        return userRepository.save(user);
    }



}
