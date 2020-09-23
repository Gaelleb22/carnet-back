package dev.carnet.entity;

/**Profil utilisateur de l'application
 * @author gaell
 *
 */
public class User extends EntiteBase{ 
	
	/* pseudo utilisé pour connexion */
	private String pseudo;
	/* mot de passe utilisé pour connexion */
	private String password;
	
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
