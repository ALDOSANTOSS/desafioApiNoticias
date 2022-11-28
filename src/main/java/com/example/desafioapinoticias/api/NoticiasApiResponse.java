package com.example.desafioapinoticias.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoticiasApiResponse {
    private String count;
    private List<Noticia> list;
}
