package test.kitchentask;

import businesslogic.CatERing;
import businesslogic.UseCaseLogicException;
import businesslogic.event.EventInfo;
import businesslogic.event.ServiceInfo;
import businesslogic.kitchentask.KitchenSheet;
import businesslogic.kitchentask.KitchenTask;
import businesslogic.procedure.Recipe;

import static businesslogic.event.ServiceInfo.getFirstServiceForEvent;

public class TestCatERingKitchenTask {
    public static void main(String[] args) {
        System.out.println("TEST FAKE LOGIN");
        CatERing catERing = CatERing.getInstance();
        catERing.getUserManager().fakeLogin("Lidia");
        System.out.println(catERing.getUserManager().getCurrentUser());

        System.out.println("\nTEST GET EVENT BY NAME");
        EventInfo event = EventInfo.getEventByName("Compleanno di Manuela");
        System.out.println(event);

        System.out.println("\nTEST GET SERVICE BY EVENT ID");
        ServiceInfo service = getFirstServiceForEvent(event);
        System.out.println(service);

        try {
            System.out.println("\nTEST CREATE SHEET");
            KitchenSheet sheet = catERing.getKitchenTaskManager().createKitchenSheet("Primo foglio di prova", event, service);
            System.out.println("Foglio autogenerato: " + sheet);

            // TODO: andare a prendere le ricette/preparazioni dal ricettario e aggiungerne una
            // fixme why? perché ci vuoi male? :') secondo me va bene anche solo così il test :O
            System.out.println("\nTEST ADD KITCHEN TASK");
            KitchenTask prepareSpaghetti = catERing.getKitchenTaskManager().addKitchenTask(new Recipe("spaghetti"));
            System.out.println("Foglio con nuovo task \"spaghetti\": "+sheet);

            System.out.println("\nTEST DELETE KITCHEN TASK");
            catERing.getKitchenTaskManager().deleteKitchenTask(prepareSpaghetti);
            System.out.println("Foglio con task \"spaghetti\" rimosso: "+sheet);

            System.out.println("\nTEST MOVE KITCHEN TASK");
            int oldPosition = 0;
            KitchenTask firstTask = sheet.getKitchenTasks().get(oldPosition);
            int newPosition = 5;
            System.out.println("Spostiamo il "+ (oldPosition+1) +" task \""+ firstTask.getProcedure()+ "\" in posizione " + newPosition);
            catERing.getKitchenTaskManager().moveTask(firstTask,newPosition);
            System.out.println("Foglio con task spostato: "+sheet);

            //TODO: getTurnTable() ma necessita della creazione delle tabelle sul db
            //TODO: assign() con tutti i suoi vari casi
            //TODO: specificaCompitoCompletato()

        } catch (UseCaseLogicException e) {
        System.out.println("Errore di logica nello use case");
    }


    }
}
