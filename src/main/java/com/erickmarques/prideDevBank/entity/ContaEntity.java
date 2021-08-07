package com.erickmarques.prideDevBank.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Table( name = "conta")
@Component
public class ContaEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String numeroAgencia;
	private String numeroConta;
	@OneToOne 
	@JoinColumn(name="idCliente", referencedColumnName="id")
	private ClienteEntity cliente;
	
	
	public int getId() {
		return id;
	}
	
	public String getNumeroAgencia() {
		return numeroAgencia;
	}
	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}
	public String getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	public ClienteEntity getCliente() {
		return cliente;
	}
	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

}
