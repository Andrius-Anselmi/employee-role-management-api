package dev.java.management.service;

import dev.java.management.entity.User;
import dev.java.management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("Buscando usuário: " + email);
        User user = (User) userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário ou password inválidos"));
        System.out.println("Usuário encontrado: " + user.getEmail() + " | Senha: " + user.getPassword());
        return user;
    }
}
