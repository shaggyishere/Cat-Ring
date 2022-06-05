package test.kitchentask;

import businesslogic.CatERing;
import businesslogic.UseCaseLogicException;
import businesslogic.event.EventInfo;
import businesslogic.event.ServiceInfo;
import businesslogic.kitchentask.KitchenSheet;
import businesslogic.kitchentask.KitchenTask;
import businesslogic.procedure.Recipe;
import businesslogic.turn.Turn;
import businesslogic.user.Cook;
import businesslogic.user.User;

import static businesslogic.event.ServiceInfo.getFirstServiceForEvent;

public class TestCatERingKitchenTask {
    public static void main(String[] args) {
        System.out.println("TEST FAKE LOGIN");
        CatERing catERing = CatERing.getInstance();
        catERing.getUserManager().fakeLogin("Lidia");
        System.out.println(catERing.getUserManager().getCurrentUser());

//        System.out.println("\nTEST GET EVENT BY NAME");
        EventInfo event = EventInfo.getEventByName("Compleanno di Manuela");
//        System.out.println(event);

//        System.out.println("\nTEST GET SERVICE BY EVENT ID");
        ServiceInfo service = getFirstServiceForEvent(event);
//        System.out.println(service);

        try {
            System.out.println("\nTEST CREATE SHEET");
            KitchenSheet sheet = catERing.getKitchenTaskManager().createKitchenSheet("Primo foglio di prova", event, service);
            System.out.println("Foglio autogenerato per evento \""+ event.getName() +"\": " + sheet);

            // fixme "andare a prendere le ricette/preparazioni dal ricettario e aggiungerne una" ->
            // fixme why? perché ci vuoi male? :') secondo me va bene anche solo così il test :O
            System.out.println("\nTEST ADD KITCHEN TASK");
            KitchenTask prepareSpaghetti = catERing.getKitchenTaskManager().addKitchenTask(new Recipe("spaghetti"));
            System.out.println("Foglio con nuovo task \"spaghetti\": "+sheet);

            System.out.println("\nTEST DELETE KITCHEN TASK");
            catERing.getKitchenTaskManager().deleteKitchenTask(prepareSpaghetti);
            System.out.println("Foglio con task \"spaghetti\" rimosso: "+sheet);

            System.out.println("\nTEST MOVE KITCHEN TASK");
            int firstPosition = 0;
            KitchenTask firstTask = sheet.getKitchenTasks().get(firstPosition);
            int newPosition = 5;
            System.out.println("Spostiamo il "+ (firstPosition+1) +" task \""+ firstTask.getProcedure()+ "\" in posizione " + newPosition);
            catERing.getKitchenTaskManager().moveTask(firstTask,newPosition);
            System.out.println("Foglio con task spostato: "+sheet);

            //TODO: getTurnTable() ma necessita della creazione delle tabelle sul db

            //TODO: assign() con tutti i suoi vari casi
            System.out.println("\nTEST ASSIGN VALUES TO FIRST TASK");
            int marinellaID = 4;
            User cookMarinella = User.loadUserById(marinellaID);
            Turn turn = new Turn("Giovedi ore 16:00");
            String timing = "50 minuti";
            String quantity = "6 porzioni";
            firstTask = sheet.getKitchenTasks().get(firstPosition);
            System.out.println(String.format("Assegniamo al primo task il cuoco: %s, nel turno: %s, con durata: %s e quantita': %s", cookMarinella.getUserName(), turn.getWhen(), timing, quantity));
//            catERing.getKitchenTaskManager().assignTask(firstTask, turn, (Cook) cookMarinella, timing, quantity); //fixme lasciare Cook oppure passare ad avere solo User
            catERing.getKitchenTaskManager().assignTask(firstTask, turn, timing, quantity);
            System.out.println("Foglio con primo task assegnato: "+sheet);

            //TODO: specificaCompitoCompletato()

        } catch (UseCaseLogicException e) {
        System.out.println("Errore di logica nello use case");
    }


    }
}
