package com.erickmarques.prideDevBank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erickmarques.prideDevBank.entity.ContaEntity;
import com.erickmarques.prideDevBank.entity.TransacaoEntity;
import com.erickmarques.prideDevBank.repository.TransacaoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

	@Autowired
	TransacaoRepository transacao;

	@Autowired
	ContaService contaService;

	public TransacaoEntity registrarTransferencia(TransacaoEntity novaTransacao) {
		String desc = novaTransacao.getDescricao();
			if (desc.equals("saque")) {

				novaTransacao.setContaOrigem(
						contaService.sacar(novaTransacao.getContaOrigem(), novaTransacao.getValorTransacao()));

			} else if (desc.equals("deposito")) {

				novaTransacao.setContaDestino(
						contaService.depositar(novaTransacao.getContaDestino(), novaTransacao.getValorTransacao()));

			} else if (desc.equals("transferencia")) {
				ContaEntity[] contaEntity = contaService.transferir(novaTransacao.getContaOrigem(),
						novaTransacao.getContaDestino(), novaTransacao.getValorTransacao());
				novaTransacao.setContaOrigem(contaEntity[0]);
				novaTransacao.setContaDestino(contaEntity[1]);
			}
			transacao.save(novaTransacao);
			return novaTransacao;
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
