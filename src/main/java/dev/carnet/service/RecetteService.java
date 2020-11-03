package dev.carnet.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.carnet.entity.AppliUser;
import dev.carnet.entity.LabelQuantite;
import dev.carnet.entity.Recette;
import dev.carnet.entity.Statut;
import dev.carnet.repository.RecetteRepository;

@Service
public class RecetteService {
	
	private RecetteRepository recetteRepo;

	/** Constructor */
	public RecetteService(RecetteRepository recetteRepo) {
		this.recetteRepo = recetteRepo;
	}
	
	public Optional<Recette> getByUuid(UUID uuid) {
		return recetteRepo.findById(uuid);
	}
	
	public List<Recette> lister(){
		return recetteRepo.findAll();
	}
	
	public Recette creer(String nom, int tempsPreparation, int tempsCuisson, int classement, Statut statut, int quantite, 
			LabelQuantite label, String urlPhoto, AppliUser user) {
		Recette recette = new Recette();
		recette.setNom(nom);
		recette.setTempsPreparation(tempsPreparation);
		recette.setTempsCuisson(tempsCuisson);
		recette.setClassement(classement);
		recette.setStatut(statut);
		recette.setQuantite(quantite);
		recette.setLabel(label);
		recette.setUrlPhoto(urlPhoto);
		recette.setUser(user);
		
		return recetteRepo.save(recette);
		
	}
	
}
