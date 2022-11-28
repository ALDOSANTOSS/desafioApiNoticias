package com.example.desafioapinoticias.entity;

import com.example.desafioapinoticias.dto.CadastraDadosUser;
import com.example.desafioapinoticias.dto.DadosAtualizacaoUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;


@Table(name = "usuarios")
@Entity(name = "User")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String password;

    @ManyToMany
    private List<Tag> tags;

    

    public User(CadastraDadosUser dados,List<Tag> tags) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.password = dados.password();
        this.tags = tags;

    }

    public User(CadastraDadosUser dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.password = dados.password();
    }


    public void atualizarInformacoes(DadosAtualizacaoUser dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.password() != null) {
            this.password = dados.password();
        }

    }

}
