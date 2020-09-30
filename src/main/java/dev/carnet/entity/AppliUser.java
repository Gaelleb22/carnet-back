package dev.carnet.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**Profil utilisateur de l'application
 * @author gaell
 *
 */
@Entity
public class AppliUser extends EntiteBase{ 
	
	/** pseudo utilisé pour connexion */
	private String pseudo;
	/** mot de passe utilisé pour connexion */
	private String password;
	
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
	
}
