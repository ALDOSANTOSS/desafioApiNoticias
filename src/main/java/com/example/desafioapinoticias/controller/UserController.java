package com.example.desafioapinoticias.controller;

import com.example.desafioapinoticias.dto.DadosUser;
import com.example.desafioapinoticias.entity.User;
import com.example.desafioapinoticias.services.UserService;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    public void cadastrarUser(@RequestBody @Valid DadosUser dados){
        service.saveUser(new User(dados));
    }
}
