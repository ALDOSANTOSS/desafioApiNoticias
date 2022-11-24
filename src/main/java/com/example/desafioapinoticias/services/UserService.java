package com.example.desafioapinoticias.services;

import com.example.desafioapinoticias.dto.DadosListaUser;
import com.example.desafioapinoticias.entity.User;
import com.example.desafioapinoticias.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public DadosListaUser buscarIdUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        User dados = user.orElseThrow();
        return new DadosListaUser(dados);

    }

    public Page<User> buscarTodos(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User atualizar(Long id) {
        return userRepository.getReferenceById(id);
    }

}
