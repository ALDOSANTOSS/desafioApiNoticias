package com.example.desafioapinoticias.controller;

import com.example.desafioapinoticias.dto.DadosUser;
import com.example.desafioapinoticias.entity.User;
import com.example.desafioapinoticias.services.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public void cadastrarUser(@RequestBody @Valid DadosUser dados){
        service.saveUser(new User(dados));
    }
}
