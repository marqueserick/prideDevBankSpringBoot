package com.erickmarques.prideDevBank.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.erickmarques.prideDevBank.entity.ClienteEntity;
import com.erickmarques.prideDevBank.services.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping(value="/cliente")
	@ResponseBody
	public ResponseEntity<ClienteEntity> novaConta(@RequestBody ClienteEntity clienteEntity){
		
		ClienteEntity clienteResponse = clienteService.novoCliente(clienteEntity);
		URI uri = URI.create("/cliente"+clienteEntity.getId());
		return ResponseEntity.created(uri).body(clienteResponse);
	}
	
//	@RequestMapping(value = "/cliente", method = RequestMethod.POST)
//	public  ResponseEntity<ClienteEntity> criaCliente(@RequestParam("nome") String nome, @RequestParam("cpf")String cpf,
//			@RequestParam("nomeSocial")String nomeSocial){
//		
//		ClienteEntity cliente = new ClienteEntity(nome, cpf, nomeSocial);
//		ClienteEntity clienteResponse = service.criarNovoCliente(cliente);
//		URI uri = URI.create("/cliente/" + clienteResponse.getId());
//		
//		return ResponseEntity.created(uri).body(clienteResponse);	
//	}
	
	@GetMapping("/cliente/{id}")
	@ResponseBody
	public ClienteEntity pesquisaCliente(@PathVariable("id") Integer id) {
		
		return clienteService.pesquisarCliente(id);
		
	}

}
