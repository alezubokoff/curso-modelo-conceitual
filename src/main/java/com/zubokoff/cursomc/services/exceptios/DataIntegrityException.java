package com.zubokoff.cursomc.services.exceptios;

public class DataIntegrityException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DataIntegrityException(String msg) {
		super(msg);
	}
	
	public DataIntegrityException(String msg, Throwable causa) {
		super(msg, causa);
	}

}
