package test.kitchentask;

import businesslogic.CatERing;
import businesslogic.UseCaseLogicException;
import businesslogic.event.EventInfo;
import businesslogic.event.ServiceInfo;
import businesslogic.kitchentask.KitchenSheet;
import businesslogic.kitchentask.KitchenTask;
import businesslogic.procedure.Recipe;
import javafx.collections.ObservableList;

import static businesslogic.event.ServiceInfo.getFirstServiceForEvent;

public class TestCatERingKitchenTask2b {
    public static void main(String[] args) {
        System.out.println("TEST FAKE LOGIN");
        CatERing catERing = CatERing.getInstance();
        catERing.getUserManager().fakeLogin("Lidia");
        System.out.println(catERing.getUserManager().getCurrentUser());

        EventInfo event = EventInfo.getEventByName("Compleanno di Manuela");
        ServiceInfo service = getFirstServiceForEvent(event);

        try {
            System.out.println("\nTEST CREATE SHEET");
            KitchenSheet sheet = catERing.getKitchenTaskManager().createKitchenSheet("Primo foglio di prova", event, service);
            System.out.println("Foglio autogenerato: " + sheet);

            System.out.println("\nTEST ADD KITCHEN TASK");
            KitchenTask prepareSpaghetti = catERing.getKitchenTaskManager().addKitchenTask(new Recipe("spaghetti"));
            KitchenTask preparePizza = catERing.getKitchenTaskManager().addKitchenTask(new Recipe("pizza"));
            KitchenTask prepareSpinaci = catERing.getKitchenTaskManager().addKitchenTask(new Recipe("spinaci"));
            KitchenTask prepareInsalata = catERing.getKitchenTaskManager().addKitchenTask(new Recipe("insalata"));
            System.out.println("Foglio con nuovi task: " + sheet);

            System.out.println("\nTEST RESTORE KITCHEN TASK");
            catERing.getKitchenTaskManager().restoreOriginalTasks();
            System.out.println("Foglio ripristinato: " + sheet);

        } catch (UseCaseLogicException e) {
            System.out.println("Errore di logica nello use case");

        }
    }
}
