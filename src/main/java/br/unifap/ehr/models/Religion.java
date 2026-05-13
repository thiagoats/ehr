package br.unifap.ehr.models;

import lombok.Getter;

public enum Religion {
	
	CATHOLICISM("Católico"),
    PROTESTANTISM("Evangélico"),
    SPIRITISM("Espírita"),
    UMBANDA("Umbanda"),
    CANDOMBLE("Candomblé"),
    JUDAISM("Judaísmo"),
    HINDUISM("Hinduísmo"),
    BUDDHISM("Budismo"),
    ISLAM("Islamismo"),
    NONE("Sem religião"),
    UNDECLARED("Não declarado");
	
	@Getter
	private String description;
	
	private Religion(String description) {
		this.description = description;
	}
}