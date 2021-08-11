package com.erickmarques.prideDevBank.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.erickmarques.prideDevBank.entity.ClienteEntity;
import com.erickmarques.prideDevBank.repository.ClienteRepository;
import static com.erickmarques.prideDevBank.util.Validador.validarCPF;;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	ClienteEntity clienteEntity;

	
	public ClienteEntity novoCliente(ClienteEntity clienteEntity) {
		
		validarCPF(clienteEntity.getCpf());
		clienteRepository.save(clienteEntity);
		return clienteEntity;
	}
	
	public ClienteEntity pesquisarCliente(Integer id) {
		Optional<ClienteEntity> clienteOptional = clienteRepository.findById(id);
		
		if(clienteOptional.isPresent()) {
			return clienteOptional.get();
		}
		
		return null;
	}
	
}
