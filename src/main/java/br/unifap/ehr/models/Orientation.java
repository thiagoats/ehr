package br.unifap.ehr.models;

import lombok.Getter;

@Getter
public enum Orientation {
	
	ASSEXU("ASSEXU", "Assexual"),
	BISEXU("BISEXU", "Bissexual"),
	HETERO("HETERO", "Heterossexual"),
	HOMOSX("HOMOSX", "Homossexual"),
	PANSEX("PANSEX", "Pansexual");
	
	private String name;
	
	private String description;
	
	private Orientation(String name, String description) {
		this.name = name;
		this.description = description;
	}
}