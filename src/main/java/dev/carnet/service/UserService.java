package dev.carnet.service;

import org.springframework.stereotype.Service;

import dev.carnet.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepo;

	/** Constructor */
	public UserService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
}
