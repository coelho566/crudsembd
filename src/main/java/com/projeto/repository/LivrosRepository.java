package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.model.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long > {


}
