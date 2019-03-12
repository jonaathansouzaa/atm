package com.atm.exception;

public class SaqueInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 8401771543501064309L;

	public SaqueInvalidoException(String message) {
		super(message);
	}

}
