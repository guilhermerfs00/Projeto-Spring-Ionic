package com.guilhermerfs00.cursomc.services.exceptions;

public class DataIntegrityException extends RuntimeException{

	private static final long serialVersionUID = -5748707329574334050L;
	
	public DataIntegrityException(String msg) {
			super(msg);
	}
	public DataIntegrityException (String msg, Throwable cause) {
		super (msg,cause);
	}
}
