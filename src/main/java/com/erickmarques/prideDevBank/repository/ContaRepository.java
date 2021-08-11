package com.erickmarques.prideDevBank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erickmarques.prideDevBank.entity.ContaEntity;

@Repository
public interface ContaRepository extends JpaRepository<ContaEntity,Integer> {
	
	List<ContaEntity> findByNumeroAgenciaAndNumeroContaEquals(String numeroAgencia, String numeroConta);
	
	

}
