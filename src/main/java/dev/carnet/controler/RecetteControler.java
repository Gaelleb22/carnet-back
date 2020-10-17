package dev.carnet.controler;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.carnet.entity.AppliUser;
import dev.carnet.entity.Recette;
import dev.carnet.service.AppliUserService;
import dev.carnet.service.RecetteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("recettes")
public class RecetteControler {
	
	private RecetteService recetteService;
	private AppliUserService userService;
	
	Logger logger = Logger.getLogger(RecetteControler.class.getName());
	
	public RecetteControler(RecetteService recetteService, AppliUserService userService) {
		this.recetteService = recetteService;
		this.userService = userService;
	}
	
	//get user connecté
	public Optional<AppliUser> findUserConnecte() {
		String pseudo = SecurityContextHolder.getContext().getAuthentication().getName();
		return userService.findByPseudo(pseudo);
	}
	
	// Get getRecetteByUuid()
	
	// Recette de l'utilisateur :
	// Get getAll() (ordre alphabétique)
	@GetMapping
	public List<Recette> getAllUserConnecte(){
		return this.findUserConnecte().get().getRecettes();
	}
	
	// Get getAllTriByClassement() (trié par "classement" plus grand au plus petit)
	//cf classement sucré/salé
	
	// Recette des autres utilisateurs
	// Get getAllOtherUser() (seulement si statut partage, ordre alphabétique)
	// Get getAllOtherUserByClassement() (trié par "classement" plus grand au plus petit)
	//cf classement sucré/salé
	
	// Post newRecette()
	
	// Update updateRecette() (seulement possible avec ses propres recettes)
	
	// Delete deleteRecette()

}
