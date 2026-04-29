package br.unifap.ehr.models;

import lombok.Getter;

/**
 * Role model enum
 * @author Thiago Pinheiro do Nascimento
 * @version 0.1
**/
public enum Role {

	/**
	 * Available roles
	**/
	ADM("ADM", "Administrador"),
	ENF("ENF", "Enfermeiro"),
	MED("MED", "Médico");
	
	/**
	 * Role authority
	**/
	@Getter
	private String authority;
	
	/**
	 * Role description
	**/
	@Getter
	private String description;
	
	/**
	 * Role constructor 
	**/
	private Role(String authority, String description) {
		this.authority = authority;
		this.description = description;
	}
}