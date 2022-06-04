package test.kitchentask;

import businesslogic.CatERing;
import businesslogic.UseCaseLogicException;
import businesslogic.event.EventInfo;
import businesslogic.event.ServiceInfo;
import businesslogic.kitchentask.KitchenSheet;
import javafx.collections.ObservableList;

import static businesslogic.event.ServiceInfo.getFirstServiceForEvent;

public class TestCatERingKitchenTask {
    public static void main(String[] args) {
        //Menu m = CatERing.getInstance().getMenuManager().createMenu("Menu Pinco Pallino");
        System.out.println("TEST FAKE LOGIN");
        CatERing.getInstance().getUserManager().fakeLogin("Lidia");
        System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());

        System.out.println("\nTEST GET EVENT BY NAME");
        EventInfo event = EventInfo.getEventByName("Compleanno di Manuela");
        System.out.println(event);

        System.out.println("\nTEST GET SERVICE BY EVENT ID");
        ServiceInfo service = getFirstServiceForEvent(event);
        System.out.println(service);

        try {
            System.out.println("\nTEST CREATE SHEET");
            KitchenSheet sheet = CatERing.getInstance().getKitchenTaskManager().createKitchenSheet("Primo foglio di prova", event, service);
            System.out.println(sheet);

//            System.out.println("\nTEST ADD KITCHEN TASK");
            // TODO: andare a prendere le ricette/preparazioni dal ricettario e aggiungerne una
//            KitchenTask preparePizza = CatERing.getInstance().getKitchenTaskManager().addKitchenTask(new Preparation());
//            KitchenTask prepareSpaghetti = CatERing.getInstance().getKitchenTaskManager().addKitchenTask(new Recipe("pizza"));
//            System.out.println(sheet);

        } catch (UseCaseLogicException e) {
        System.out.println("Errore di logica nello use case");
    }


    }
}
