package dev.carnet.controler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.carnet.dto.CreerIngredientDto;
import dev.carnet.dto.CreerRecetteDto;
import dev.carnet.entity.AppliUser;
import dev.carnet.entity.Ingredient;
import dev.carnet.entity.LabelQuantite;
import dev.carnet.entity.Recette;
import dev.carnet.entity.Statut;
import dev.carnet.exception.UserNotFoundException;
import dev.carnet.service.AppliUserService;
import dev.carnet.service.IngredientService;
import dev.carnet.service.RecetteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("recettes")
public class RecetteControler {
	
	private RecetteService recetteService;
	private AppliUserService userService;
	private IngredientService ingredientService;
	
	Logger logger = Logger.getLogger(RecetteControler.class.getName());
	
	public RecetteControler(RecetteService recetteService, AppliUserService userService, IngredientService ingredientService) {
		this.recetteService = recetteService;
		this.userService = userService;
		this.ingredientService = ingredientService;
	}
	
	//get user connecté
	private Optional<AppliUser> findUserConnecte() {
		String pseudo = SecurityContextHolder.getContext().getAuthentication().getName();
		return userService.findByPseudo(pseudo);
	}
	
	// Get getRecetteByUuid()
	@GetMapping("{uuid}")
	@Secured(value = "ROLE_UTILISATEUR, ROLE_ADMINISTRATEUR")
	public Recette getRecetteByUuid(@PathVariable UUID uuid) {
		return recetteService.getByUuid(uuid).get();
	}
	
	// Recette de l'utilisateur :
	// Get getAll() (ordre alphabétique)
	@GetMapping
	@Secured(value = "ROLE_UTILISATEUR, ROLE_ADMINISTRATEUR")
	public ResponseEntity<?> getAllUserConnecte(){
		List<Recette> recettes = this.findUserConnecte().get().getRecettes();
		return ResponseEntity.status(HttpStatus.OK).body(recettes);
	}
	
	// Get getAllTriByClassement() (trié par "classement" plus grand au plus petit)
	//cf classement sucré/salé
	
	// Recette des autres utilisateurs
	// Get getAllOtherUser() (seulement si statut partage, ordre alphabétique)
	// Get getAllOtherUserByClassement() (trié par "classement" plus grand au plus petit)
	//cf classement sucré/salé
	
	// Post newRecette()
	@PostMapping
	@Secured(value = "ROLE_UTILISATEUR, ROLE_ADMINISTRATEUR")
	public ResponseEntity<?> postNewRecette(@RequestBody @Valid CreerRecetteDto recetteDto, BindingResult result) {
		
		Recette nouvelleRecette = recetteService.creer(
				recetteDto.getNom(), recetteDto.getTempsPreparation(), recetteDto.getTempsCuisson(),
				recetteDto.getClassement(), 
				Statut.valueOf(recetteDto.getStatut()), recetteDto.getQuantite(), 
				LabelQuantite.valueOf(recetteDto.getLabel()),
				recetteDto.getUrlPhoto(), this.findUserConnecte().get());
		
		List<Ingredient> ingredients = new ArrayList<>();
		for(CreerIngredientDto ing : recetteDto.getIngredients()) {
			ingredients.add(ingredientService.creer(ing.getNom(), ing.getQuantite(), nouvelleRecette));
		}
		
		nouvelleRecette.setIngredients(ingredients);
		
		return ResponseEntity.ok(nouvelleRecette);
	}
	
	// Update updateRecette() (seulement possible avec ses propres recettes)
	
	// Delete deleteRecette()

}
