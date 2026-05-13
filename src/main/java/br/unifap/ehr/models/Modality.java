package br.unifap.ehr.models;

import lombok.Getter;

public enum Modality {
	
	CISGENDER("Cisgênero"),
	TRANSGENDER("Transgênero"),
	UNDECLARED("Não declarado");
	
	@Getter
	private String description;
	
	private Modality(String description) {
		this.description = description;
	}
}