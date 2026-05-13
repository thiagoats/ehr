package br.unifap.ehr.models;

import lombok.Getter;

public enum Disability {

	NONE("Nenhuma"),
    PHYSICAL("Física"),
    VISUAL("Visual"),
    HEARING("Auditiva"),
    INTELLECTUAL("Intelectual"),
    MULTIPLES("Múltiplas"),
    OSTOMY("Estomia"),
    UNDECLARED("Não declarada");
	
	@Getter
	private String description;
	
	private Disability(String description) {
		this.description = description;
	}
}