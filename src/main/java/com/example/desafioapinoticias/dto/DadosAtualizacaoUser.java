package com.example.desafioapinoticias.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUser(@NotNull Long id, String nome, String password, String email) {
}
