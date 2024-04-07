package sia.tacocloud.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import sia.tacocloud.Ingredient;
import sia.tacocloud.data.IngredientRepository;

@Component 
public class IngredientByIdConverter implements Converter<String, Ingredient> {   
	private IngredientRepository ingredientRepo;

	public IngredientByIdConverter(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}
		
	@Override  
	public Ingredient convert(@SuppressWarnings("null") String id) {  
		return ingredientRepo.findById(id).orElse(null); 
	}  
}