package dev.carnet.dto;

import java.util.List;
import java.util.UUID;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import dev.carnet.entity.LabelQuantite;
import dev.carnet.entity.Statut;

public class CreerRecetteDto {
	
	/** nom */
	@NotNull
	@NotBlank
	@Size(min=2)
	@JsonProperty("nom")
	private String nom;
	
	/** temps de préparation */
	@NotNull
	@NotBlank
	@PositiveOrZero
	@JsonProperty("preparation")
	private int tempsPreparation;
	
	/** temps de cuisson */
	@NotNull
	@NotBlank
	@PositiveOrZero
	@JsonProperty("cuisson")
	private int tempsCuisson;
	
	/** classement de 0 à 5 */
	@NotNull
	@NotBlank
	@Min(0)
	@Max(5)
	@JsonProperty("classement")
	private int classement;
	
	/** statut */
	@NotNull
	@NotBlank
	@JsonProperty("statut")
	private String statut;
	
	/** quantité */
	@NotNull
	@NotBlank
	@PositiveOrZero
	@JsonProperty("quantite")
	private int quantite;
	
	/** label quantité */
	@NotNull
	@NotBlank
	@JsonProperty("label")
	private String label;
	
	/** url photo */
	@NotNull
	@NotBlank
	@JsonProperty("url")
	private String urlPhoto;
	
	/** liste d'ingrétients */
	@JsonProperty("ingredients")
	private List<CreerIngredientDto> ingredients;
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getTempsPreparation() {
		return tempsPreparation;
	}

	public void setTempsPreparation(int tempsPreparation) {
		this.tempsPreparation = tempsPreparation;
	}

	public int getTempsCuisson() {
		return tempsCuisson;
	}

	public void setTempsCuisson(int tempsCuisson) {
		this.tempsCuisson = tempsCuisson;
	}

	public int getClassement() {
		return classement;
	}

	public void setClassement(int classement) {
		this.classement = classement;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getUrlPhoto() {
		return urlPhoto;
	}

	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	public List<CreerIngredientDto> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<CreerIngredientDto> ingredients) {
		this.ingredients = ingredients;
	}

}
