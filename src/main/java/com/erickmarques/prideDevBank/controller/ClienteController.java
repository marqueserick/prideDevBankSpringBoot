package com.erickmarques.prideDevBank.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.erickmarques.prideDevBank.entity.ClienteEntity;
import com.erickmarques.prideDevBank.services.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(value = "/cliente", method = RequestMethod.POST)
	public  ResponseEntity<ClienteEntity> criaCliente(@RequestParam("nome") String nome, @RequestParam("cpf")String cpf,
			@RequestParam("nomeSocial")String nomeSocial) {
		ClienteEntity cliente = new ClienteEntity(nome, cpf, nomeSocial);
		ClienteEntity clienteResponse = service.criarNovoCliente(cliente);
		URI uri = URI.create("/cliente/" + clienteResponse.getId());
		
		return ResponseEntity.created(uri).body(clienteResponse);
		
	}
	
	@GetMapping("/cliente/{id}")
	public ClienteEntity pesquisaCliente(@PathVariable("id") Integer id) {
		
		return service.pesquisaCliente(id);
		
	}

}
