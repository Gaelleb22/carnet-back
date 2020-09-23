package dev.carnet.entity;

import javax.persistence.Entity;

/**Conseil culinaire
 * @author gaell
 *
 */
@Entity
public class Conseil extends EntiteBase {
	
	private String nom;
	private String texte;
	private String categorie;
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	

}
