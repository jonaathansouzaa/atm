package com.atm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.atm.enumerations.NotaEnum;
import com.atm.exception.SaqueInvalidoException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Class of Tests ATM
 */
@RunWith(MockitoJUnitRunner.class)
public class AtmTest {

	@InjectMocks
	private Atm atm;

	@Test
	public void testSeSaque30RetornaValorDesejado() {
		List<NotaEnum> notas = atm.realizaSaque(30);
		assertEquals(1L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_20)).count());
		assertEquals(1L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_10)).count());
	}

    @Test
    public void testSeSaque40RetornaValorDesejado() {
        List<NotaEnum> notas = atm.realizaSaque(40);
        assertEquals(2L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_20)).count());
    }

	@Test
	public void testSeSaque80RetornaValorDesejado() {
        List<NotaEnum> notas = atm.realizaSaque(80);
        assertEquals(1L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_50)).count());
        assertEquals(1L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_20)).count());
        assertEquals(1L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_10)).count());
    }

    @Test
    public void testSeSaque130RetornaValorDesejado() {
        List<NotaEnum> notas = atm.realizaSaque(130);
        assertEquals(1L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_100)).count());
        assertEquals(1L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_20)).count());
        assertEquals(1L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_10)).count());
    }

    @Test
    public void testSeSaque150RetornaValorDesejado() {
        List<NotaEnum> notas = atm.realizaSaque(200);
        assertEquals(2L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_100)).count());
    }

    @Test
    public void testSeSaque200RetornaValorDesejado() {
        List<NotaEnum> notas = atm.realizaSaque(150);
        assertEquals(1L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_100)).count());
        assertEquals(1L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_50)).count());
    }

    @Test
    public void testSeSaque1230RetornaValorDesejado() {
        List<NotaEnum> notas = atm.realizaSaque(1230);
        assertEquals(12L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_100)).count());
        assertEquals(1L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_20)).count());
        assertEquals(1L, notas.stream().filter(nota -> nota.equals(NotaEnum.NOTA_10)).count());
    }

	@Test()
	public void testSeSaqueDeValorInvalidoRetornaException() {
		Assertions.assertThatThrownBy(() -> atm.realizaSaque(15))
				.isInstanceOf(SaqueInvalidoException.class)
				.hasMessage("Não é possível realizar este saque, valor incorreto.");
	}
	
}
