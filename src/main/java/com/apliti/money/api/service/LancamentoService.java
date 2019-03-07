package com.apliti.money.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.apliti.money.api.model.Lancamento;
import com.apliti.money.api.model.Pessoa;
import com.apliti.money.api.repository.LancamentoRepository;
import com.apliti.money.api.repository.PessoaRepository;
import com.apliti.money.api.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {
	
	@Autowired
	LancamentoRepository lancamentoRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	public Lancamento atualizar(Long codigo, Lancamento lancamento) {
		Lancamento lancamentoSalva = buscarLancamentoPeloCodigo(codigo);

		BeanUtils.copyProperties(lancamento, lancamentoSalva, "codigo");
		return lancamentoRepository.save(lancamentoSalva);

	}

	private Lancamento buscarLancamentoPeloCodigo(Long codigo) {
		Lancamento lancamentoSalva = lancamentoRepository.getOne(codigo);
		if (lancamentoSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return lancamentoSalva;
	}

	public Lancamento salvar(Lancamento lancamento) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo());
		if (! pessoa.isPresent()) {
			throw new PessoaInexistenteOuInativaException();
		}
		return lancamentoRepository.save(lancamento);
	}

}
