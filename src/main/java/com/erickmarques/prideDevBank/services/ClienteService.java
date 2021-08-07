package com.erickmarques.prideDevBank.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.erickmarques.prideDevBank.entity.ClienteEntity;
import com.erickmarques.prideDevBank.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteEntity clienteEntity;
	
	public ClienteEntity criarNovoCliente(ClienteEntity clienteEntity) {
		
		clienteRepository.save(clienteEntity);
		return clienteEntity;
	}
	
	public ClienteEntity pesquisaCliente(Integer id) {
		Optional<ClienteEntity> clienteOptional = clienteRepository.findById(id);
		
		if(clienteOptional.isPresent()) {
			return clienteOptional.get();
		}
		
		return null;
	}
	
}
