package dev.carnet.service;

import org.springframework.stereotype.Service;

import dev.carnet.repository.RecetteRepository;

@Service
public class RecetteService {
	
	private RecetteRepository recetteRepo;

	/** Constructor */
	public RecetteService(RecetteRepository recetteRepo) {
		this.recetteRepo = recetteRepo;
	}
	
}
