package dev.carnet.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.carnet.entity.AppliUser;
import dev.carnet.repository.AppliUserRepository;

@Service
public class AppliUserService {
	
	private AppliUserRepository userRepo;

	/** Constructor */
	public AppliUserService(AppliUserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public Optional<AppliUser> findByPseudo(String pseudo){
		return userRepo.findByPseudo(pseudo);
	}
	
	public Optional<AppliUser> findByUuid(UUID uuid) {
		return userRepo.findById(uuid);
	}
	
}
