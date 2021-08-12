package com.erickmarques.prideDevBank.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erickmarques.prideDevBank.entity.ContaEntity;
import com.erickmarques.prideDevBank.exceptions.ContaInvalidaException;
import com.erickmarques.prideDevBank.repository.ContaRepository;
import static com.erickmarques.prideDevBank.util.Validador.temSaldo;;

@Service
public class ContaService {

	@Autowired
	ContaRepository contaRepository;

	public ContaEntity novaConta(ContaEntity contaEntity) {

		contaRepository.save(contaEntity);
		return contaEntity;
	}

	public ContaEntity pesquisarPorAgenciaEConta(String numeroAgencia, String numeroConta) {

		ContaEntity contaEntity = contaRepository.findByNumeroAgenciaAndNumeroContaEquals(numeroAgencia,
				numeroConta);
		if (contaEntity != null) {
			return contaEntity;
		} else {
			throw new ContaInvalidaException();
		}

	}

	public ContaEntity pesquisarConta(Integer id) {

		Optional<ContaEntity> contaOptional = contaRepository.findById(id);

		if (contaOptional.isPresent()) {
			return contaOptional.get();
		}

		return null;
	}

	public ContaEntity depositar(ContaEntity contaEntity, float valorDeposito) {
		contaEntity = this.pesquisarPorAgenciaEConta(contaEntity.getNumeroAgencia(), contaEntity.getNumeroConta());
		contaEntity.setSaldo(contaEntity.getSaldo() + valorDeposito);
		contaRepository.save(contaEntity);
		return contaEntity;
	}

	public ContaEntity sacar(ContaEntity contaEntity, float valorSaque) {
		contaEntity = this.pesquisarPorAgenciaEConta(contaEntity.getNumeroAgencia(), contaEntity.getNumeroConta());
		temSaldo(contaEntity.getSaldo(), valorSaque);
		contaEntity.setSaldo(contaEntity.getSaldo() - valorSaque);
		contaRepository.save(contaEntity);
		return contaEntity;
	}

	public ContaEntity[] transferir(ContaEntity contaOrigem, ContaEntity contaDestino, float valorSaque) {
		contaOrigem = this.sacar(contaOrigem, valorSaque);
		contaDestino = this.depositar(contaDestino, valorSaque);
		ContaEntity[] contaEntity = { contaOrigem, contaDestino };
		return contaEntity;
	}

}
