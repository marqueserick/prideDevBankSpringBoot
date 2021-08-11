package com.erickmarques.prideDevBank.entity;

import javax.persistence.*;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@Entity
@Table(name = "cliente", uniqueConstraints = @UniqueConstraint(columnNames = { "cpf" }))
@Component
public class ClienteEntity implements Serializable {

	public ClienteEntity() {

	}

	public ClienteEntity(String nome, String cpf, String nomeSocial) {
		this.nome = nome;
		this.cpf = cpf;
		this.nomeSocial = nomeSocial;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NonNull
	@JsonProperty("nome")
	private String nome;

	@NonNull
	@JsonProperty("cpf")
	private String cpf;

	@JsonProperty("nomeSocial")
	private String nomeSocial;

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

}
