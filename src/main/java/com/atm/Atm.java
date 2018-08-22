package com.atm;

import java.util.ArrayList;
import java.util.List;

import com.atm.enumerations.NotaEnum;
import com.atm.exception.SaqueInvalidoException;

public class Atm {

	public List<NotaEnum> realizaSaque(Integer valor) {
		ArrayList<NotaEnum> notas = new ArrayList<NotaEnum>();
		
		Boolean executeCalculo = true;
		while (executeCalculo) {
			if ((valor - NotaEnum.NOTA_100.getValor()) >= 0) {
				valor = reduzValorEAdicionaNota(valor, NotaEnum.NOTA_100, notas);
			} else if ((valor - NotaEnum.NOTA_50.getValor()) >= 0) {
				valor = reduzValorEAdicionaNota(valor, NotaEnum.NOTA_50, notas);
			} else if ((valor - NotaEnum.NOTA_20.getValor()) >= 0) {
				valor = reduzValorEAdicionaNota(valor, NotaEnum.NOTA_20, notas);
			} else if ((valor - NotaEnum.NOTA_10.getValor()) >= 0) {
				valor = reduzValorEAdicionaNota(valor, NotaEnum.NOTA_10, notas);
			} else {
				executeCalculo = false;
			}
		}
		
		if (valor > 0) {
			throw new SaqueInvalidoException();
		}
		
		return notas;
	}

	private Integer reduzValorEAdicionaNota(Integer valor, NotaEnum notaEnum, ArrayList<NotaEnum> notas) {
		valor -= notaEnum.getValor();
		notas.add(notaEnum);
		return valor;
	}

}
