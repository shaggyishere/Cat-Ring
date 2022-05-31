package businesslogic.recipe;

import java.util.ArrayList;
import java.util.List;

public abstract class Procedure {
	private List <ProcedureIngredient> ingredients;

	// TODO: volendo costruttore da riempire un po' almeno per i test (es. titolo, qlc)
	public Procedure(List<ProcedureIngredient> ingredients) {
		this.ingredients = ingredients;
	}

	public List<ProcedureIngredient> getIngredients() {
		return ingredients;
	}

	//this method extract all the procedures from the recipe list passed by argument
	public static List<Procedure> retrieveProceduresToPrepare(List<Recipe> recipesToExtract) {
		List<Procedure> procedures = new ArrayList<>(recipesToExtract);

		for (Recipe recipe: recipesToExtract){
			List <ProcedureIngredient> ingredientsRecipe = recipe.getIngredients();
			if (ingredientsRecipe != null){
				for (ProcedureIngredient procIng: ingredientsRecipe){
					Ingredient ing = procIng.getIngredient();
					if (ing instanceof Preparation)
						procedures.add((Preparation) ing);
				}
			}
		}

		return procedures;
	}
}
