package dev.carnet.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.carnet.entity.Etape;
import dev.carnet.entity.Recette;
import dev.carnet.repository.EtapeRepository;

@Service
public class EtapeService {
	
	private EtapeRepository etapeRepo;

	/** Constructor */
	public EtapeService(EtapeRepository etapeRepo) {
		this.etapeRepo = etapeRepo;
	}
	
	@Transactional
	public Etape creer(String texte, Recette recette) {
		Etape etape = new Etape();
		etape.setTexte(texte);
		etape.setRecette(recette);
		
		return etapeRepo.save(etape);
	}
	

}
