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
	/** cuisson 
	private Boolean cuisson;*/
	/** temps de cuisson */
	@Column(name = "temps_cuisson")
	private int tempsCuisson;
	/** type de cuisson 
	@Column(name = "type_cuisson")
	private TypeCuisson typeCuisson;*/
	/** repos 
	private Boolean repos;*/
	/** temps de repos 
	@Column(name = "temps_repos")
	private int tempsRepos;*/
	/** classement de 0 à 5 */
	private int classement;
	/** statut */
	private Statut statut;
	/** quantité */
	private int quantite;
	/** label quantité */
	private LabelQuantite label;
	/** url photo */
	@Column(name = "url_photo")
	private String urlPhoto;
	
	@OneToMany(mappedBy = "recette",
			cascade = CascadeType.ALL,
	        orphanRemoval = true)
	@JsonManagedReference
	private List<Ingredient> ingredients;

	@OneToMany(mappedBy = "recette",
			cascade = CascadeType.ALL,
	        orphanRemoval = true)
	@JsonManagedReference
	private List<Etape> etapes;

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
	public int getTempsCuisson() {
		return tempsCuisson;
	}
	public void setTempsCuisson(int tempsCuisson) {
		this.tempsCuisson = tempsCuisson;
	}
	
	/**
	public Boolean getCuisson() {
		return cuisson;
	}
	public void setCuisson(Boolean cuisson) {
		this.cuisson = cuisson;
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
	public TypeCuisson getTypeCuisson() {
		return typeCuisson;
	}
	public void setTypeCuisson(TypeCuisson typeCuisson) {
		this.typeCuisson = typeCuisson;
	}*/
	
	public int getClassement() {
		return classement;
	}
	public void setClassement(int classement) {
		this.classement = classement;
	}
	public Statut getStatut() {
		return statut;
	}
	public void setStatut(Statut statut) {
		this.statut = statut;
	}
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	public List<Astuce> getAstuces() {
		return astuces;
	}
	public void setAstuces(List<Astuce> astuces) {
		this.astuces = astuces;
	}
	public AppliUser getUser() {
		return user;
	}
	public void setUser(AppliUser user) {
		this.user = user;
	}
	public String getUrlPhoto() {
		return urlPhoto;
	}
	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}
	public List<Etape> getEtapes() {
		return etapes;
	}
	public void setEtapes(List<Etape> etapes) {
		this.etapes = etapes;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public LabelQuantite getLabel() {
		return label;
	}
	public void setLabel(LabelQuantite label) {
		this.label = label;
	}

}
