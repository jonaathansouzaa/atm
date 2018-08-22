package com.atm;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.atm.enumerations.NotaEnum;
import com.atm.exception.SaqueInvalidoException;

/**
 * Class of Tests ATM
 */
public class AtmTest {
	
	@Test
	public void testSeSaque30RetornaValorDesejado() {
		Atm atm = new Atm();
		List<NotaEnum> notas = atm.realizaSaque(30);
		assertEquals(1L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_20)).count());
		assertEquals(1L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_10)).count());

		notas = atm.realizaSaque(80);
		assertEquals(1L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_50)).count());
		assertEquals(1L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_20)).count());
		assertEquals(1L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_10)).count());

		notas = atm.realizaSaque(130);
		assertEquals(1L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_100)).count());
		assertEquals(1L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_20)).count());
		assertEquals(1L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_10)).count());

		notas = atm.realizaSaque(150);
		assertEquals(1L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_100)).count());
		assertEquals(1L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_50)).count());

		notas = atm.realizaSaque(40);
		assertEquals(2L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_20)).count());
		
		notas = atm.realizaSaque(200);
		assertEquals(2L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_100)).count());

		notas = atm.realizaSaque(1230);
		assertEquals(12L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_100)).count());
		assertEquals(1L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_20)).count());
		assertEquals(1L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_10)).count());
	}
	
	@Test(expected = SaqueInvalidoException.class)
	public void testSeSaqueDeValorInvalidoRetornaException() {
		Atm atm = new Atm();
		atm.realizaSaque(15);
	}
	
}
