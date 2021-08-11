package com.erickmarques.prideDevBank.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "conta")
@Component
public class ContaEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NonNull
	@JsonProperty("numeroAgencia")
	private String numeroAgencia;

	@NonNull
	@JsonProperty("numeroConta")
	private String numeroConta;

	@JsonProperty("saldo")
	private float saldo;

	@NonNull
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idCliente", referencedColumnName = "id")
	private ClienteEntity cliente;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

}
