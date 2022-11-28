package com.example.desafioapinoticias.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Noticia {
    private String title;
    private String description;
    private String link;
    private String datetime;
    private String date;
    private String time;
}
