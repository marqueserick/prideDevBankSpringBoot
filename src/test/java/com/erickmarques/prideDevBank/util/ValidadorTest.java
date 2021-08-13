package com.erickmarques.prideDevBank.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.erickmarques.prideDevBank.exceptions.SaldoInsuficienteException;

import static com.erickmarques.prideDevBank.util.Validador.validarCPF;
import static com.erickmarques.prideDevBank.util.Validador.temSaldo;

public class ValidadorTest {
	
	@Test
	void naoDeveValidarCpfComLetras() {
		String cpf = "1234567890a";
		Assertions.assertThrows(RuntimeException.class,()-> validarCPF(cpf));
		
	}
	
	@Test
	void deveValidarCpf(){
		String cpf = "12345678909";
		Assertions.assertDoesNotThrow(()->validarCPF(cpf));
	}
	
	@Test
	void naoDeveValidarCpfIncompleto() {
		String cpf = "1234567890";
		Assertions.assertThrows(RuntimeException.class,()-> validarCPF(cpf));
	}
	
	@Test
	void naoDeveSacarSeSaldoMenorQueValorSaque(){
		
		Assertions.assertThrows(SaldoInsuficienteException.class,()-> temSaldo(100,101));
		
	}
	
	@Test
	void deveSacarSeSaldoMaiorOuIgualQueValorSaque(){
		
		Assertions.assertDoesNotThrow(()-> temSaldo(101,101));
		Assertions.assertDoesNotThrow(()-> temSaldo(102,101));
		
	}
}
