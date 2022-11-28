package com.example.desafioapinoticias.entity;

import com.example.desafioapinoticias.dto.CadastraTagDados;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;


@Table(name = "tags")
@Entity(name = "tb_tag")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tag {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private Long views = 0L;


    @ManyToMany(mappedBy = "tags")
    private List<User> users;


    public Tag(CadastraTagDados dados) {
        this.nome = dados.nome();

    }
}
