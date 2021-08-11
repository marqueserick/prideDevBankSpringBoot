package com.erickmarques.prideDevBank.exceptions;

public class SaldoInsuficienteException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SaldoInsuficienteException() {
		super("Saldo Insuficiente");
	}

}
