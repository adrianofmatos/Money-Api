package com.apliti.money.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apliti.money.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
