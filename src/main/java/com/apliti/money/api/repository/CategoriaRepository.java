package com.apliti.money.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apliti.money.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
