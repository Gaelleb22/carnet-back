package dev.carnet.service;

import org.springframework.stereotype.Service;

import dev.carnet.repository.ConseilRepository;

@Service
public class ConseilService {
	
	private ConseilRepository conseilRepo;

	/** Constructor */
	public ConseilService(ConseilRepository conseilRepo) {
		this.conseilRepo = conseilRepo;
	}
	
}
