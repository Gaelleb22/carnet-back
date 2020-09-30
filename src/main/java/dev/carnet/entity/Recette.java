package dev.carnet.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**Recette de cuisine
 * @author gaell
 *
 */
@Entity
public class Recette extends EntiteBase {
	
	/** nom */
	private String nom;
	/** temps de préparation */
	@Column(name = "temps_preparation")
	private int tempsPreparation;
	/** cuisson */
	private Boolean cuisson;
	/** temps de cuisson */
	@Column(name = "temps_cuisson")
	private int tempsCuisson;
	/** type de cuisson */
	@Column(name = "type_cuisson")
	private TypeCuisson typeCuisson;
	/** repos */
	private Boolean repos;
	/** temps de repos */
	@Column(name = "temps_repos")
	private int tempsRepos;
	/** classement de 0 à 5 */
	private int classement;
	/** statut */
	private Statut statut;
	
	@OneToMany(mappedBy = "recette",
			cascade = CascadeType.ALL,
	        orphanRemoval = true)
	@JsonManagedReference
	private List<Ingredient> ingredients;

	@OneToMany(mappedBy = "recette",
			cascade = CascadeType.ALL,
	        orphanRemoval = true)
	@JsonManagedReference
	private List<EtapePreparation> etapesPreparation;

	@OneToMany(mappedBy = "recette",
			cascade = CascadeType.ALL,
	        orphanRemoval = true)
	@JsonManagedReference
	private List<Astuce> astuces;
	
	@ManyToOne
	@JoinColumn(name = "user_uuid")
	@JsonBackReference
	private AppliUser user;
	
	
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
	public Boolean getCuisson() {
		return cuisson;
	}
	public void setCuisson(Boolean cuisson) {
		this.cuisson = cuisson;
	}
	public int getTempsCuisson() {
		return tempsCuisson;
	}
	public void setTempsCuisson(int tempsCuisson) {
		this.tempsCuisson = tempsCuisson;
	}
	public Boolean getRepos() {
		return repos;
	}
	public void setRepos(Boolean repos) {
		this.repos = repos;
	}
	public int getTempsRepos() {
		return tempsRepos;
	}
	public void setTempsRepos(int tempsRepos) {
		this.tempsRepos = tempsRepos;
	}
	public int getClassement() {
		return classement;
	}
	public void setClassement(int classement) {
		this.classement = classement;
	}

}
