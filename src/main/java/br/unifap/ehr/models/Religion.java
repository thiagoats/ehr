package br.unifap.ehr.models;

import lombok.Getter;

public enum Religion {
	
    CATHOLICISM("Catolicismo"),
    PROTESTANTISM("Protestantismo"),
    SPIRITISM("Espiritismo"),
    ISLAM("Islamismo"),
    JUDAISM("Judaísmo"),
    BUDDHISM("Budismo"),
    HINDUISM("Hinduísmo"),
    CANDOMBLE("Candomblé"),
    UMBANDA("Umbanda"),
    AGNOSTICISM("Agnosticismo"),
    ATHEISM("Ateísmo"),
    NONE("Sem religião"),
    OTHER("Outra");
	
	@Getter
	private String description;
	
	private Religion(String description) {
		this.description = description;
	}
}