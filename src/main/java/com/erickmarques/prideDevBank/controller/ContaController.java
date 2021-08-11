package com.erickmarques.prideDevBank.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.erickmarques.prideDevBank.entity.ContaEntity;
import com.erickmarques.prideDevBank.services.ContaService;

@RestController
public class ContaController {
	
	@Autowired
	ContaService contaService;
	
	@PostMapping(value="/conta")
	@ResponseBody
	public ResponseEntity<ContaEntity> novaConta(@RequestBody ContaEntity contaEntity){
		
		ContaEntity contaResponse = contaService.novaConta(contaEntity);
		URI uri = URI.create("/conta"+contaEntity.getId());
		return ResponseEntity.created(uri).body(contaResponse);
	}
	
	@GetMapping("/conta/{id}")
	@ResponseBody
	public ContaEntity pesquisarConta(@PathVariable("id") Integer id) {
		
		return contaService.pesquisarConta(id);
		
	}
	
	

}
