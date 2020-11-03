package dev.carnet.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.carnet.dto.UserDao;
import dev.carnet.repository.AppliUserRepository;

@RestController
public class AuthentificationControler {
	
	private AppliUserRepository userRepo;

	public AuthentificationControler(AppliUserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	@GetMapping("/me")
    public ResponseEntity<?> quiSuisJe() {
        String pseudo = SecurityContextHolder.getContext().getAuthentication().getName();
        return this.userRepo.findByPseudo(pseudo)
                .map(UserDao::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }
	
}
