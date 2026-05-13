package br.unifap.ehr.models;

import lombok.Getter;

public enum Ethnicity {
	
	WHITE("Branca"),
	BLACK("Preta"),
	BROWN("Parda"),
	YELLOW("Amarela"),
	INDIGENOUS("Indígena"),
	UNDECLARED("Não declarada");
	
	@Getter
	private String description;
	
	private Ethnicity(String description) {
		this.description = description;
	}
}