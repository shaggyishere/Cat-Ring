package businesslogic.recipe;

import java.util.ArrayList;
import java.util.List;

public class Procedure {
    //this method extract all the procedures from the recipe list passed by argument
    public static List<Procedure> retrieveRecipeToPrepare(List<Recipe> recipesToExtract) {
        List<Procedure> procedures = new ArrayList<>();

        //TODO: search inside the recipe's ingredient the preparations used and add to procedure list
        for (Recipe recipe : recipesToExtract) {
            procedures.add(recipe);
        }
        return procedures;
    }
}
