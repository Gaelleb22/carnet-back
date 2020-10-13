package dev.carnet.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**Profil utilisateur de l'application
 * @author gaell
 *
 */
@Entity
@Table(name = "user")
public class AppliUser extends EntiteBase{ 
	
	/** pseudo utilisé pour connexion */
	private String pseudo;
	
	/** mot de passe utilisé pour connexion */
	private String password;
	
	/** roles */
	private Role role;
	
	@OneToMany(mappedBy = "user",
			cascade = CascadeType.ALL,
	        orphanRemoval = true)
	@JsonManagedReference
	private List<Recette> recettes;
	
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public List<Recette> getRecettes() {
		return recettes;
	}
	public void setRecettes(List<Recette> recettes) {
		this.recettes = recettes;
	}
	
}
