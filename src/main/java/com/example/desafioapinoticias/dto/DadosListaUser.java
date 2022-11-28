package com.example.desafioapinoticias.dto;


import com.example.desafioapinoticias.entity.User;

import java.util.List;

public record DadosListaUser(Long id, String nome, String email, List<DadosTagList> tags) {
    public DadosListaUser(User user){
        this(user.getId(),user.getNome(), user.getEmail(),user.getTags().stream().map(DadosTagList::new).toList());
    }
}
