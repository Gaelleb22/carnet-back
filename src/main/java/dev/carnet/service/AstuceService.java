package dev.carnet.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.carnet.entity.Astuce;
import dev.carnet.entity.Recette;
import dev.carnet.repository.AstuceRepository;

@Service
public class AstuceService {
	
	private AstuceRepository astuceRepo;

	/** Constructor */
	public AstuceService(AstuceRepository astuceRepo) {
		this.astuceRepo = astuceRepo;
	}
	
	@Transactional
	public Astuce creer(String texte, Recette recette) {
		Astuce astuce = new Astuce();
		astuce.setAstuce(texte);
		astuce.setRecette(recette);
		
		return astuceRepo.save(astuce);
	}

}
