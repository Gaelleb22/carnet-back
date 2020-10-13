package dev.carnet.service;

import org.springframework.stereotype.Service;

import dev.carnet.repository.AppliUserRepository;

@Service
public class AppliUserService {
	
	private AppliUserRepository userRepo;

	/** Constructor */
	public AppliUserService(AppliUserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
}
