package br.com.reflector.exception;


public class MissingPropertyException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7863404273499637818L;

	public MissingPropertyException(String message){
		super(message);
	}

}
