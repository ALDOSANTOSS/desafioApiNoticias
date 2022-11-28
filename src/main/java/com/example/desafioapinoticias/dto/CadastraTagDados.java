package com.example.desafioapinoticias.dto;

import jakarta.validation.constraints.NotBlank;

public record CadastraTagDados(@NotBlank String nome, Long views) {
}
