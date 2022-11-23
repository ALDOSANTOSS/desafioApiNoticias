package com.example.desafioapinoticias.entity;

import com.example.desafioapinoticias.dto.CadastraDadosUser;
import com.example.desafioapinoticias.dto.DadosAtualizacaoUser;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


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
