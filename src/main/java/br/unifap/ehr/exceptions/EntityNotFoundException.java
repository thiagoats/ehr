package br.unifap.ehr.exceptions;

/**
 * Entity not found exception
 * @author Thiago Pinheiro do Nascimento
 * @since 0.1
**/
public class EntityNotFoundException extends RuntimeException {

	/**
	 * Unique identifier for the serialization version of this class.
	**/
	private static final long serialVersionUID = 1L;

	/**
	 * Entity not found exception constructor
	**/
	public EntityNotFoundException(String message) {
		super(message);
	}
}