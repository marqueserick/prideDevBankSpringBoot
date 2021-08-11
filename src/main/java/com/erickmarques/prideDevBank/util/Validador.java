package com.erickmarques.prideDevBank.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.erickmarques.prideDevBank.exceptions.SaldoInsuficienteException;

public class Validador {
	
	public static void validarCPF(String cpf) {

        String patternString = "[0-9]{11}";

        Pattern pattern = Pattern.compile(patternString);

        Matcher matcher = pattern.matcher(cpf);
        boolean matches = matcher.matches();
        
        if(!matches) {
        	throw new RuntimeException("CPF Invalido");
        }
	}
	
	public static void temSaldo(float saldo, float valorTransacao) {
		
		if(valorTransacao>saldo) {
			throw new SaldoInsuficienteException();
		}
	}

}
