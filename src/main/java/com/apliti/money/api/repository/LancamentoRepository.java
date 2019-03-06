package com.apliti.money.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apliti.money.api.model.Lancamento;
import com.apliti.money.api.repository.lancamento.LancamentoRepositoryQuery;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {

}
