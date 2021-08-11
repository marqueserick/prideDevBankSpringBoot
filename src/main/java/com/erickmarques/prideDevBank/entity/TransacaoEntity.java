package com.erickmarques.prideDevBank.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "transacao")
@Component
public class TransacaoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NonNull
	@JsonProperty("valor")
	private float valorTransacao;

	@NonNull
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idContaOrigem", referencedColumnName = "id")
	private ContaEntity contaOrigem;

	@NonNull
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idContaDestino", referencedColumnName = "id")
	private ContaEntity contaDestino;
	
	public TransacaoEntity() {
		
	}
	
	public TransacaoEntity(float valorTransacao, ContaEntity contaOrigem, ContaEntity contaDestino) {
		this.valorTransacao = valorTransacao;
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getValorTransacao() {
		return valorTransacao;
	}

	public void setValorTransacao(float valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

	public ContaEntity getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(ContaEntity contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public ContaEntity getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(ContaEntity contaDestino) {
		this.contaDestino = contaDestino;
	}

}
