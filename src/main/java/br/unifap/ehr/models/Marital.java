package br.unifap.ehr.models;

import lombok.Getter;

public enum Marital {
	
	SINGLE("Solteiro"),
	MARRIED("Casado"),
	DIVORCED("Divorciado"),
	WIDOMED("Viúvo"),
	SEPARATED("Separado"),
	STABLE_UNION("União estável");
	
	@Getter
	private String description;
	
	private Marital(String description) {
		this.description = description;
	}
}