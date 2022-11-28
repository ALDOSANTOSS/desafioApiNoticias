package com.example.desafioapinoticias.services;


import com.example.desafioapinoticias.entity.Tag;
import com.example.desafioapinoticias.repository.TagRepository;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    private final TagRepository repository;

    public TagService(TagRepository repository) {
        this.repository = repository;
    }

    public void saveTag(Tag tag) {
        repository.save(tag);
    }
}
