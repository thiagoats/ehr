package br.unifap.ehr.models;

import lombok.Getter;

@Getter
public enum Religion {
	
	BUDI("BUDI", "Budísmo"),
	CAND("CAND", "Candomblé"),
	CATO("CATO", "Católico"),
	ESPI("ESPI", "Espírita"),
	EVAN("EVAN", "Evangélico"),
	HIND("HIND", "Hinduísmo"),
	ISLA("ISLA", "Islamísmo"),
	JUDA("JUDA", "Judaísmo"),
	UMBA("UMBA", "Umbanda");
	
	private String name;
	
	private String description;
	
	private Religion(String name, String description) {
		this.name = name;
		this.description = description;
	}
}