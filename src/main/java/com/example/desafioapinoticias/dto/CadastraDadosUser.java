package com.example.desafioapinoticias.dto;

import com.example.desafioapinoticias.entity.Tag;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record CadastraDadosUser(@NotBlank String nome, @Email String email, String password, List<Tag> tags) {
}
