package com.erickmarques.prideDevBank.exceptions;

public class ContaInvalidaException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ContaInvalidaException() {
		super("Conta Inexistente");
	}
}
