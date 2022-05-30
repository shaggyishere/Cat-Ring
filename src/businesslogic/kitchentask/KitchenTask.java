package businesslogic.kitchentask;

import businesslogic.recipe.Procedure;
import businesslogic.turn.Turn;
import businesslogic.user.Cook;

public class KitchenTask {
    private String timing;
    private String quantity;
    private boolean completed;
    private Procedure procedure;
    private Turn turn;
    private Cook cook;
}
