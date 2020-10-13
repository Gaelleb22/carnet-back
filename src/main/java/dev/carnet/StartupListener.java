package dev.carnet;

import javax.transaction.Transactional;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dev.carnet.entity.AppliUser;
import dev.carnet.entity.Role;
import dev.carnet.repository.AppliUserRepository;

/**
 * Code de démarrage de l'application. Insertion de jeux de données.
 */
@Component
@Transactional
public class StartupListener {

	private PasswordEncoder passwordEncoder;
	private AppliUserRepository appliUserRepo;

	public StartupListener(PasswordEncoder passwordEncoder,
			AppliUserRepository appliUserRepo) {
		this.passwordEncoder = passwordEncoder;
		this.setAppliUserRepo(appliUserRepo);
	}

	public AppliUserRepository getAppliUserRepo() {
		return appliUserRepo;
	}

	public void setAppliUserRepo(AppliUserRepository appliUserRepo) {
		this.appliUserRepo = appliUserRepo;
	}

	@EventListener(ContextRefreshedEvent.class)
	public void onStart() {

		/*AppliUser moi = new AppliUser();
		moi.setPseudo("Moi");
		moi.setPseudo(passwordEncoder.encode("superpass"));
		moi.setRole(Role.ROLE_ADMINISTRATEUR);
		
		this.appliUserRepo.save(moi);
		
		AppliUser toi = new AppliUser();
		toi.setPseudo("Toi");
		toi.setPseudo(passwordEncoder.encode("superpass"));
		toi.setRole(Role.ROLE_UTILISATEUR);
		
		this.appliUserRepo.save(toi);*/
		
	}
}
