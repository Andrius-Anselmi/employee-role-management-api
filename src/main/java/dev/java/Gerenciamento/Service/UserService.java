package dev.java.Gerenciamento.Service;

import dev.java.Gerenciamento.Repository.UserRepository;
import dev.java.Gerenciamento.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User registrar(User user){
        return userRepository.save(user);
    }



}
