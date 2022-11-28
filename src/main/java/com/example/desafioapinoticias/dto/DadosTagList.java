package com.example.desafioapinoticias.dto;

import com.example.desafioapinoticias.entity.Tag;

public record DadosTagList(String nome) {

    public  DadosTagList(Tag tag){
        this(tag.getNome());
    }

}
