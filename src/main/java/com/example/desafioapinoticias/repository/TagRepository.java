package com.example.desafioapinoticias.repository;

import com.example.desafioapinoticias.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository< Tag, Long> {
}
