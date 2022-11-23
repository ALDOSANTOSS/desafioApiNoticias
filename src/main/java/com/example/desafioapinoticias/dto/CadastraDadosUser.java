package com.example.desafioapinoticias.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CadastraDadosUser(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        String password) {
}
