package com.example.desafioapinoticias.dto;

import com.example.desafioapinoticias.entity.User;

public record DadosListaUser(Long id,String nome, String email) {
    public DadosListaUser(User user){
        this(user.getId(),user.getNome(), user.getEmail());
    }
}
