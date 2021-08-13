package com.erickmarques.prideDevBank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erickmarques.prideDevBank.entity.ContaEntity;
import com.erickmarques.prideDevBank.entity.TransacaoEntity;

@Repository
public interface TransacaoRepository extends JpaRepository <TransacaoEntity, Integer> {
	
	List<TransacaoEntity> findByContaOrigemOrContaDestino(ContaEntity contaOrigem, ContaEntity contaDestino);

}
