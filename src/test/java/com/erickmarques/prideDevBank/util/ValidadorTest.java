package com.erickmarques.prideDevBank.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static com.erickmarques.prideDevBank.util.Validador.validarCPF;;

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

}
