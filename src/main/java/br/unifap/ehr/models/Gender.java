package br.unifap.ehr.models;

import lombok.Getter;

@Getter
public enum Gender {
	
	FEM("FEM", "Feminino"),
	MAS("MAS", "Masculino");
	
	private String name;
	
	private String description;
	
	private Gender(String name, String description) {
		this.name = name;
		this.description = description;
	}
}