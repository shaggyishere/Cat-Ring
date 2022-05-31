package businesslogic.recipe;

public class ProcedureIngredient {
	private String quantity;
	private Ingredient ingredient;

	public ProcedureIngredient(String quantity, Ingredient ingredient) {
		this.quantity = quantity;
		this.ingredient = ingredient;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}
}
