package dev.carnet.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**Ingrédient d'une recette
 * @author gaell
 *
 */
@Entity
public class Ingredient extends EntiteBase {
	
	private String nom;
	private String quantite;
	
	@ManyToOne
	@JoinColumn(name = "recette_uuid")
	@JsonBackReference
	private Recette recette;

	public String getQuantite() {
		return quantite;
	}
	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
