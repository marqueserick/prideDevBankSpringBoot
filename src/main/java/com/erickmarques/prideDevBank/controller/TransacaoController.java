package com.erickmarques.prideDevBank.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.erickmarques.prideDevBank.services.ContaService;
import com.erickmarques.prideDevBank.services.TransacaoService;
import com.erickmarques.prideDevBank.entity.ContaEntity;
import com.erickmarques.prideDevBank.entity.TransacaoEntity;

@RestController
public class TransacaoController {

	@Autowired
	TransacaoService transacao;

	@Autowired
	ContaEntity contaEntity;

	@Autowired
	ContaService contaService;

	@PostMapping(value = "/transacao")
	@ResponseBody
	public ResponseEntity<TransacaoEntity> registrarTransacao(@RequestBody TransacaoEntity transacaoEntity) {
			TransacaoEntity transacaoResponse = transacao.registrarTransacao(transacaoEntity);
			URI uri = URI.create("/transacao" + transacaoEntity.getId());
			return ResponseEntity.created(uri).body(transacaoResponse);

	}
	
	@GetMapping("/transacao/{idContaOrigem}")
	@ResponseBody
	public List<TransacaoEntity> pesquisarTransacoesDaConta(@PathVariable("idContaOrigem") Integer id) {
		return transacao.pesquisarTransacoesDaConta(contaService.pesquisarConta(id));
		
	}

}
