package dev.carnet.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreerIngredientDto {
	
	@NotNull
	@NotBlank
	@Size(min=2)
	private String nom;
	@NotNull
	@NotBlank
	private String quantite;
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getQuantite() {
		return quantite;
	}
	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}
	
}
