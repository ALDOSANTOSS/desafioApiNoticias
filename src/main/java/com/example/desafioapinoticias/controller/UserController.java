package com.example.desafioapinoticias.controller;

import com.example.desafioapinoticias.dto.CadastraDadosUser;
import com.example.desafioapinoticias.dto.DadosListaUser;
import com.example.desafioapinoticias.dto.DadosAtualizacaoUser;
import com.example.desafioapinoticias.entity.User;
import com.example.desafioapinoticias.services.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    @PostMapping
    @Transactional
    public void cadastrarUser(@RequestBody @Valid CadastraDadosUser dados) {
        service.saveUser(new User(dados));
    }

    @GetMapping
    public Page<DadosListaUser> listar(Pageable paginacao) {
        return service.buscarTodos(paginacao).map(DadosListaUser::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoUser dados) {
        var user = service.atualizar(dados.id());
        user.atualizarInformacoes(dados);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        service.deleteUser(id);

    }


}
