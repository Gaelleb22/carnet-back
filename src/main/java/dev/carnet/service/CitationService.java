package dev.carnet.service;

import org.springframework.stereotype.Service;

import dev.carnet.repository.CitationRepository;

@Service
public class CitationService {
	
	private CitationRepository citationRepo;

	/** Constructor */
	public CitationService(CitationRepository citationRepo) {
		this.citationRepo = citationRepo;
	}

}
