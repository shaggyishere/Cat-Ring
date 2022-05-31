package businesslogic.procedure;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProcedureManager {

    // TODO: Procedure.loadAllProcedures() (??) se a noi non serve, io non lo farei
    // volendo ok lasciarlo commentato così le ricordiamo che in un altro caso d'uso si fa
    public ProcedureManager() {
        Recipe.loadAllRecipes();
//        Procedure.loadAllProcedures();
    }

    public ObservableList<Recipe> getRecipes() {
        return FXCollections.unmodifiableObservableList(Recipe.getAllRecipes());
    }
}
