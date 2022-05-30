package businesslogic.kitchentask;

import businesslogic.event.ServiceInfo;
import businesslogic.menu.Menu;
import businesslogic.recipe.Procedure;
import businesslogic.recipe.Recipe;

import java.util.ArrayList;
import java.util.List;

public class KitchenSheet {
    private String title;
    private List<KitchenTask> kitchenTasks;
    private ServiceInfo kitchenSheetService;

    public KitchenSheet(String title, ServiceInfo service) {
        this.title = title;
        this.kitchenSheetService = service;
        this.kitchenTasks = new ArrayList<>();

        Menu menu = service.getUsedMenu();

        List<Recipe> recipes = menu.getRecipes();

        List<Procedure> procedures = Procedure.retrieveRecipeToPrepare(recipes);

        for (Procedure proc : procedures) {
            KitchenTask task = new KitchenTask(proc);
            kitchenTasks.add(task);
        }
    }

    @Override
    public String toString() {
        return "KitchenSheet{" +
                "title='" + title + '\'' +
                ", kitchenTasks=" + kitchenTasks +
                ", kitchenSheetService=" + kitchenSheetService +
                '}';
    }
}
