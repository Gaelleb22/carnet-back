package dev.carnet.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.carnet.entity.AppliUser;
import dev.carnet.entity.Role;
import dev.carnet.repository.AppliUserRepository;

@Service
public class AppliUserService {
	
	private AppliUserRepository userRepo;

	/** Constructor */
	public AppliUserService(AppliUserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public List<AppliUser> findAll(){
		return userRepo.findAll();
	}
	
	public Optional<AppliUser> findByPseudo(String pseudo){
		return userRepo.findByPseudo(pseudo);
	}
	
	public Optional<AppliUser> findByUuid(UUID uuid) {
		return userRepo.findById(uuid);
	}
	
	public Optional<AppliUser> findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	@Transactional
	public AppliUser creer(String pseudo, String password, String email, Role role) {
		AppliUser user = new AppliUser();
		user.setPseudo(pseudo);
		user.setPassword(password);
		user.setEmail(email);
		user.setRole(role);
		
		return userRepo.save(user);
	}
	
}
