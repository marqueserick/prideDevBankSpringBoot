package com.erickmarques.prideDevBank.dominio;


public class Cliente {

	private int id;
	private String nome;
	private String cpf;
	private String nomeSocial;

	public Cliente() {

	}

	public Cliente(String nome, String cpf, String nomeSocial) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.nomeSocial = nomeSocial;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
