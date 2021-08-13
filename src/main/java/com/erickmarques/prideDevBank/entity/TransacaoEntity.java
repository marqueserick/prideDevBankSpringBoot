package com.erickmarques.prideDevBank.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.*;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	
	@JsonProperty("descricao")
	private String descricao;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
	@JsonProperty("data")
	private LocalDateTime data;

	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idContaOrigem", referencedColumnName = "id")
	private ContaEntity contaOrigem;

	
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
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String showDateAndTime() {
		DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return this.getData().format(form);
	}
	public LocalDateTime getData() {
		
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
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
