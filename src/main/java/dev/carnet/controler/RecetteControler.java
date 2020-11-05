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

import dev.carnet.dto.CreerAstuceDto;
import dev.carnet.dto.CreerEtapeDto;
import dev.carnet.dto.CreerIngredientDto;
import dev.carnet.dto.CreerRecetteDto;
import dev.carnet.entity.AppliUser;
import dev.carnet.entity.Astuce;
import dev.carnet.entity.Etape;
import dev.carnet.entity.Ingredient;
import dev.carnet.entity.LabelQuantite;
import dev.carnet.entity.Recette;
import dev.carnet.entity.Statut;
import dev.carnet.exception.CodeErreur;
import dev.carnet.exception.MessageDto;
import dev.carnet.exception.RecetteException;
import dev.carnet.exception.UserNotFoundException;
import dev.carnet.service.AppliUserService;
import dev.carnet.service.AstuceService;
import dev.carnet.service.EtapeService;
import dev.carnet.service.IngredientService;
import dev.carnet.service.RecetteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("recettes")
public class RecetteControler {
	
	private RecetteService recetteService;
	private AppliUserService userService;
	private IngredientService ingredientService;
	private EtapeService etapeService;
	private AstuceService astuceService;
	
	Logger logger = Logger.getLogger(RecetteControler.class.getName());
	
	public RecetteControler(RecetteService recetteService, AppliUserService userService, IngredientService ingredientService, 
			EtapeService etapeService, AstuceService astuceService) {
		this.recetteService = recetteService;
		this.userService = userService;
		this.ingredientService = ingredientService;
		this.etapeService = etapeService;
		this.astuceService = astuceService;
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
		
		try {

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
			
			List<Etape> etapes = new ArrayList<>();
			for(CreerEtapeDto etape : recetteDto.getEtapes()) {
				etapes.add(etapeService.creer(etape.getTexte(), nouvelleRecette));
			}
			
			List<Astuce> astuces = new ArrayList<>();
			for(CreerAstuceDto astuce : recetteDto.getAstuces()) {
				astuces.add(astuceService.creer(astuce.getAstuce(), nouvelleRecette));
			}
			
			nouvelleRecette.setIngredients(ingredients);
			nouvelleRecette.setEtapes(etapes);
			nouvelleRecette.setAstuces(astuces);
			
			return ResponseEntity.ok(nouvelleRecette);
		}
		catch (RuntimeException e) {
			RecetteException erreur = new RecetteException(new MessageDto(CodeErreur.VALIDATION, "Erreur de requete, arguments insufisants !"));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erreur.getMessageErreur());
		}
		
	}
	
	// Update updateRecette() (seulement possible avec ses propres recettes)
	
	// Delete deleteRecette()

}
