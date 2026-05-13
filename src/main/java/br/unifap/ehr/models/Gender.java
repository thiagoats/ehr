package br.unifap.ehr.models;

import lombok.Getter;

public enum Gender {
	
	CIS_MALE("Homem cisgênero"),
	TRANS_MALE("Homem transgênero"),
	CIS_FEMALE("Mulher cisgênero"),
	TRANS_FEMALE("Mulher transgênero"),
	NONBINARY("Não-binário"),
	OTHER("Outro");
	
	@Getter
	private String description;
	
	private Gender(String description) {
		this.description = description;
	}
}