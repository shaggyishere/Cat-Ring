package businesslogic.recipe;

import java.util.List;

public class Preparation extends Procedure implements Ingredient{

	public Preparation(List<ProcedureIngredient> ingredients) {
		super(ingredients);
	}
}
