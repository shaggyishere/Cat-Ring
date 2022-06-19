package businesslogic.procedure;

import businesslogic.kitchentask.KitchenTask;

import java.util.ArrayList;
import java.util.List;

public abstract class Procedure {
	private int id;
	private List <KitchenTask> assignedInTasks; //fixme: non utilizzato in questo caso d'uso ma necessario per un controllo nell'UC delle ricette (eliminazione procedura)
	private List <ProcedureIngredient> ingredients;

	public Procedure() {
		id = 0;
		this.ingredients = new ArrayList<>();
		this.assignedInTasks = new ArrayList<>();
	}

	public int getId() {
		return id;
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

	public void addAssignedTask(KitchenTask task){
		this.assignedInTasks.add(task);
	}

	public void removeAssignedTask(KitchenTask task){
		this.assignedInTasks.remove(task);
	}

}
