package dev.carnet.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreerEtapeDto {
	
	@NotNull
	@NotBlank
	private String texte;

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}
	

}
