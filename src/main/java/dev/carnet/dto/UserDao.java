package dev.carnet.dto;

import java.util.UUID;

import dev.carnet.entity.AppliUser;
import dev.carnet.entity.Role;

/**Modélisation d'un utilisateur
 * @author gaell
 *
 */
public class UserDao {
	
	private UUID uuid;
	private String pseudo;
	private Role role;
	
	public UserDao(AppliUser appliUser) {
		this.uuid = appliUser.getUuid();
		this.pseudo = appliUser.getPseudo();
		this.role = appliUser.getRole();
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


}
