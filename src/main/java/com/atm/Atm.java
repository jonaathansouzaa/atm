package com.atm;

import java.util.ArrayList;
import java.util.List;

import com.atm.enumerations.NotaEnum;
import com.atm.exception.SaqueInvalidoException;
import com.atm.saque.Saque100;

public class Atm {

	public List<NotaEnum> realizaSaque(Integer valor) {
		ArrayList<NotaEnum> notas = new ArrayList<NotaEnum>();
		
		Boolean executeCalculo = true;
		while (executeCalculo) {
			valor = new Saque100().doSaque(valor, notas);
			if (valor < 10) {
				executeCalculo = false;
			}
		}
		
		if (valor > 0) {
			throw new SaqueInvalidoException("Não é possível realizar este saque, valor incorreto.");
		}
		
		return notas;
	}

}
