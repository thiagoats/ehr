package br.unifap.ehr.exceptions;

import lombok.Getter;

/**
 * Entity with invalid field exception
 * @author Thiago Pinheiro do Nascimento
 * @since 0.1
**/
public class EntityWithInvalidFieldException extends Exception {

	/**
	 * Unique identifier for the serialization version of this class.
	**/
	private static final long serialVersionUID = 1L;

	/**
	 * Invalid field for the entity
	**/
	@Getter
	private String field;
	
	/**
	 * Entity with invalid field exception constructor
	**/
	public EntityWithInvalidFieldException(String message, String field) {
		super(message);
		this.field = field;
	}
}