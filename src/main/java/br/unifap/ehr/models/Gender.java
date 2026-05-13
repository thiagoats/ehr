package br.unifap.ehr.models;

import lombok.Getter;

public enum Gender {
	
	MALE("Masculino"),
	FEMALE("Feminino"),
	NONBINARY("Não binário"),
	UNDECLARED("Não declarado");
	
	@Getter
	private String description;
	
	private Gender(String description) {
		this.description = description;
	}
}