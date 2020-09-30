package dev.carnet.dao;

import dev.carnet.entity.AppliUser;

/**Modélisation d'un utilisateur
 * @author gaell
 *
 */
public class UserDao {
	
	private String pseudo;
	private String password;
	
	public UserDao(AppliUser appliUser) {
		this.pseudo = appliUser.getPseudo();
		this.password = appliUser.getPassword();
	}

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
