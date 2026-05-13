package br.unifap.ehr.models;

import lombok.Getter;

@Getter
public enum Marital {
	
	CAS("CAS", "Casado"),
	DIV("DIV", "Divorciado"),
	EST("EST", "União estável"),
	SOL("SOL", "Solteiro"),
	VIU("VIU", "Viúvo");
	
	private String name;
	
	private String description;
	
	private Marital(String name, String description) {
		this.name = name;
		this.description = description;
	}
}