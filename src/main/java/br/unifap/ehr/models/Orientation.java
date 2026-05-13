package br.unifap.ehr.models;

import lombok.Getter;

public enum Orientation {
	
	HETEROSEXUAL("Heterossexual"),
	HOMOSEXUAL("Homossexual"),
	BISEXUAL("Bissexual"),
	PANSEXUAL("Pansexual"),
	ASEXUAL("Assexual"),
	OTHER("Outra");

	@Getter
	private String description;
	
	private Orientation(String description) {
		this.description = description;
	}
}