package dev.carnet.entity;

import java.util.List;

/**Recette de cuisine
 * @author gaell
 *
 */
public class Recette extends EntiteBase {
	
	private String nom;
	private List<String> ingredients;
	private int tempsPreparation;
	private List<String> etapesPreparation;
	private Boolean cuisson;
	private int tempsCuisson;
	private Boolean repos;
	private int tempsRepo;
	private int classement;
	private List<String> astuces;
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	public int getTempsPreparation() {
		return tempsPreparation;
	}
	public void setTempsPreparation(int tempsPreparation) {
		this.tempsPreparation = tempsPreparation;
	}
	public List<String> getEtapesPreparation() {
		return etapesPreparation;
	}
	public void setEtapesPreparation(List<String> etapesPreparation) {
		this.etapesPreparation = etapesPreparation;
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
	public int getTempsRepo() {
		return tempsRepo;
	}
	public void setTempsRepo(int tempsRepo) {
		this.tempsRepo = tempsRepo;
	}
	public int getClassement() {
		return classement;
	}
	public void setClassement(int classement) {
		this.classement = classement;
	}
	public List<String> getAstuces() {
		return astuces;
	}
	public void setAstuces(List<String> astuces) {
		this.astuces = astuces;
	}
	

}
