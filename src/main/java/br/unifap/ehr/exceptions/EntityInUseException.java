package br.unifap.ehr.exceptions;

/**
 * Entity in use exception
 * @author Thiago Pinheiro do Nascimento
 * @since 0.1
**/
public class EntityInUseException extends RuntimeException {

	/**
	 * Unique identifier for the serialization version of this class.
	**/
	private static final long serialVersionUID = 1L;

	/**
	 * Entity in use exception constructor
	**/
	public EntityInUseException(String message) {
		super(message);
	}
}