package dev.carnet.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.carnet.entity.Ingredient;
import dev.carnet.entity.Recette;
import dev.carnet.repository.IngredientRepository;

@Service
public class IngredientService {
	
	private IngredientRepository ingredientRepo;

	/** Constructor	 */
	public IngredientService(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}
	
	@Transactional
	public Ingredient creer(String nom, String quantite, Recette recette) {
		Ingredient ingredient = new Ingredient();
		ingredient.setNom(nom);
		ingredient.setQuantite(quantite);
		ingredient.setRecette(recette);
		
		return ingredientRepo.save(ingredient);
	}

}
