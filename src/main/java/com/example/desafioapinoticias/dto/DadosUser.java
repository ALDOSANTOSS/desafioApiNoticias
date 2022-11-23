package com.example.desafioapinoticias.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosUser(@NotBlank
                        String nome,
                        @NotBlank
                        @Email
                        String email,
                        @NotBlank
                        String password) {
}
