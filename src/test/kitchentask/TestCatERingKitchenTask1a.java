package test.kitchentask;

import businesslogic.BusinessLogicException;
import businesslogic.CatERing;
import businesslogic.UseCaseLogicException;
import businesslogic.event.EventInfo;
import businesslogic.event.ServiceInfo;
import businesslogic.kitchentask.KitchenSheet;
import businesslogic.kitchentask.KitchenTask;
import businesslogic.procedure.Recipe;
import businesslogic.turn.Turn;
import businesslogic.user.User;

import static businesslogic.event.ServiceInfo.getFirstServiceForEvent;

public class TestCatERingKitchenTask1a {
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
            System.out.println("\nTEST OPEN EXISTING SHEET");
            KitchenSheet sheetToOpen = new KitchenSheet("Primo foglio di prova", service);
//            KitchenSheet sheetToOpen = new KitchenSheet("Pranzo di natale coi parenti", service); //foglio non presente nel db, lancerà un'eccezione
            KitchenSheet sheet = catERing.getKitchenTaskManager().chooseKitchenSheet(sheetToOpen, event, service);
            System.out.println("Foglio esistente per evento \""+ event.getName() +"\": " + sheet);

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


            System.out.println("\nTEST ASSIGN VALUES TO FIRST TASK");
            int marinellaID = 4;
            User cookMarinella = User.loadUserById(marinellaID);
            Turn tuesdayAftnoonTurn = new Turn("Martedi ore 09:00");
            cookMarinella.addAvailabilityFor(tuesdayAftnoonTurn);
            String timing = "50 minuti";
            String quantity = "6 porzioni";
            firstTask = sheet.getKitchenTasks().get(firstPosition);
            System.out.printf("Assegniamo al primo task il cuoco: %s, nel turno: %s, con durata: %s e quantita': %s%n", cookMarinella.getUserName(), tuesdayAftnoonTurn.getWhen(), timing, quantity);
            catERing.getKitchenTaskManager().assignTask(firstTask, tuesdayAftnoonTurn, cookMarinella, timing, quantity);
            System.out.println("Foglio con primo task assegnato: "+sheet);

            
            System.out.println("\nTEST SET FIRST TASK COMPLETED");
            catERing.getKitchenTaskManager().specifyCompletedTask(firstTask);
            System.out.println("Foglio con primo task completato: "+sheet);

        } catch (UseCaseLogicException e) {
            System.out.println("Errore di logica nello use case");
        } catch (BusinessLogicException e) {
            System.out.println(e.getMessage());
        }


    }
}
