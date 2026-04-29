package br.unifap.ehr.exceptions;

/**
 * Entity not persisted exception
 * @author Thiago Pinheiro do Nascimento
 * @since 0.1
**/
public class EntityNotPersistedException extends RuntimeException {

	/**
	 * Unique identifier for the serialization version of this class.
	**/
	private static final long serialVersionUID = 1L;

	/**
	 * Entity not persisted exception constructor
	**/
	public EntityNotPersistedException(String message) {
		super(message);
	}
}