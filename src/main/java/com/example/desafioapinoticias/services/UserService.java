package com.example.desafioapinoticias.services;

import com.example.desafioapinoticias.entity.User;
import com.example.desafioapinoticias.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User buscarIdUser(Long id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new Exception("Usuário nao encontrado");
        }
        return user.get();
    }

    public List<User> buscarTodos() {
        return userRepository.findAll();
    }

}
