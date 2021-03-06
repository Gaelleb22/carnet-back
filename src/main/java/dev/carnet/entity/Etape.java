package dev.carnet.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**Etapes de préparation d'une recette
 * @author gaell
 *
 */
@Entity
public class Etape extends EntiteBase {
	
	private String texte;
	
	@ManyToOne
	@JoinColumn(name = "recette_uuid")
	@JsonBackReference
	private Recette recette;

	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public Recette getRecette() {
		return recette;
	}
	public void setRecette(Recette recette) {
		this.recette = recette;
	}
	
}
