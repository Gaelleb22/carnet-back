package dev.carnet.testEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import dev.carnet.entity.AppliUser;
import dev.carnet.entity.Role;

public class TestAppliUser {
	
	@Test
	void creerUserValide() {
		AppliUser user = new AppliUser();
		user.setPseudo("Fifi Brindacier");
		user.setPassword("mot de passe");
		user.setRole(Role.ROLE_ADMINISTRATEUR);
		
		String pseudo = "Fifi Brindacier";
		String motDePasse = "mot de passe";
		Role role = Role.ROLE_ADMINISTRATEUR;
		
		assertNotNull(user);
		assertEquals(pseudo, user.getPseudo());
		assertEquals(motDePasse, user.getPassword());
		assertEquals(role, user.getRole());
		assertNotNull(user.getUuid());
	}
	
	@Test
	void creerUserTestInvalide() {
		
		AppliUser user = new AppliUser();
		user.setPseudo("Fifi Brindacier");
		user.setPassword("mot de passe");
		user.setRole(Role.ROLE_ADMINISTRATEUR);
		
		String pseudo = "FifiBrindacier";
		
		assertNotNull(user);
		assertNotEquals(pseudo, user.getPseudo());
	}
	
	@Test
	void creerUserNull() {
		AppliUser user = null;
		
		assertNull(user);
	}

}
