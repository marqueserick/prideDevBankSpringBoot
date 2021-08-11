package com.erickmarques.prideDevBank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erickmarques.prideDevBank.entity.ContaEntity;
import com.erickmarques.prideDevBank.entity.TransacaoEntity;
import com.erickmarques.prideDevBank.exceptions.SaldoInsuficienteException;
import com.erickmarques.prideDevBank.repository.TransacaoRepository;
import static com.erickmarques.prideDevBank.util.Validador.temSaldo;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

	@Autowired
	TransacaoRepository transacao;

	@Autowired
	ContaEntity contaEntity;

	@Autowired
	ContaService contaService;

	public TransacaoEntity registrarTransacao(TransacaoEntity novaTransacao) {

		try {
			novaTransacao.setContaOrigem(
					contaService.pesquisarPorAgenciaEConta(novaTransacao.getContaOrigem().getNumeroAgencia(),
							novaTransacao.getContaOrigem().getNumeroConta()));
			novaTransacao.setContaDestino(
					contaService.pesquisarPorAgenciaEConta(novaTransacao.getContaDestino().getNumeroAgencia(),
							novaTransacao.getContaDestino().getNumeroConta()));
			temSaldo(novaTransacao.getContaOrigem().getSaldo(), novaTransacao.getValorTransacao());
			transacao.save(novaTransacao);
			novaTransacao.setContaOrigem(
					contaService.sacar(novaTransacao.getContaOrigem(), novaTransacao.getValorTransacao()));
			novaTransacao.setContaDestino(
					contaService.depositar(novaTransacao.getContaDestino(), novaTransacao.getValorTransacao()));
			return novaTransacao;
		} catch (SaldoInsuficienteException e) {
			throw new SaldoInsuficienteException();
		} catch (RuntimeException e) {
			throw new RuntimeException("Conta inválida");
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro inesperado");
		}
	}

	public TransacaoEntity pesquisarTransacao(Integer id) {

		Optional<TransacaoEntity> transacaoEntity = transacao.findById(id);
		if (transacaoEntity.isPresent()) {
			return transacaoEntity.get();
		}
		return null;
	}

	public List<TransacaoEntity> pesquisarTransacoesDaConta(ContaEntity contaOrigem) {
		return transacao.findByContaOrigem(contaOrigem);
	}

}
