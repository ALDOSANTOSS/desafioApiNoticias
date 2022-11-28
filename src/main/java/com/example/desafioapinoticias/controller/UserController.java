package com.example.desafioapinoticias.controller;

import com.example.desafioapinoticias.dto.CadastraDadosUser;
import com.example.desafioapinoticias.dto.CadastraTagDados;
import com.example.desafioapinoticias.dto.DadosListaUser;
import com.example.desafioapinoticias.dto.DadosAtualizacaoUser;
import com.example.desafioapinoticias.entity.Tag;
import com.example.desafioapinoticias.entity.User;
import com.example.desafioapinoticias.services.TagService;
import com.example.desafioapinoticias.services.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userServiceservice;
    private final TagService tagService;

    public UserController(UserService userServiceservice, TagService tagService) {
        this.userServiceservice = userServiceservice;
        this.tagService = tagService;
    }


    @PostMapping
    @Transactional
    public void cadastrarUserTag(@RequestBody @Valid CadastraDadosUser dados) {
        List<Tag> tag = dados.tags();
        for (Tag tags : tag) {
            tagService.saveTag(tags);
        }
        userServiceservice.saveUser(new User(dados, tag));
    }

    @GetMapping
    public Page<DadosListaUser> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return userServiceservice.buscarTodos(paginacao).map(DadosListaUser::new);
    }

    @GetMapping("/{id}")
    @Transactional
    public DadosListaUser buscarIdUser(@PathVariable Long id) {
        return userServiceservice.buscarIdUser(id);

    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoUser dados) {
        var user = userServiceservice.atualizar(dados.id());
        user.atualizarInformacoes(dados);

    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        userServiceservice.deleteUser(id);

    }

    @PostMapping("/{tag}")
    @Transactional
    public void cadastrarTag(@RequestBody @Valid CadastraTagDados dados) {
        tagService.saveTag(new Tag(dados));


    }

    @PostMapping("/new")
    @Transactional
    public void cadastrarUser(@RequestBody @Valid CadastraDadosUser dados) {
        userServiceservice.saveUser(new User(dados));
    }


}
