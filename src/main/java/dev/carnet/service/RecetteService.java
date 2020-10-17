package dev.carnet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.carnet.entity.Recette;
import dev.carnet.repository.RecetteRepository;

@Service
public class RecetteService {
	
	private RecetteRepository recetteRepo;

	/** Constructor */
	public RecetteService(RecetteRepository recetteRepo) {
		this.recetteRepo = recetteRepo;
	}
	
	public List<Recette> lister(){
		return recetteRepo.findAll();
	}
	
}
