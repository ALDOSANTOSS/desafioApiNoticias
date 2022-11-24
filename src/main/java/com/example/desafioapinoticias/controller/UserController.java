package com.example.desafioapinoticias.controller;

import com.example.desafioapinoticias.dto.CadastraDadosUser;
import com.example.desafioapinoticias.dto.DadosListaUser;
import com.example.desafioapinoticias.dto.DadosAtualizacaoUser;
import com.example.desafioapinoticias.entity.User;
import com.example.desafioapinoticias.services.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public Page<DadosListaUser> listar(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao) {
        return service.buscarTodos(paginacao).map(DadosListaUser::new);
    }

    @GetMapping("/{id}")
    @Transactional
    public DadosListaUser buscarIdUser (@PathVariable Long id) {
        return service.buscarIdUser(id);

    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoUser dados) {
        var user = service.atualizar(dados.id());
        user.atualizarInformacoes(dados);

    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.deleteUser(id);

    }


}
