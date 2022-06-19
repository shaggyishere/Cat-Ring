package test.kitchentask;

import businesslogic.CatERing;
import businesslogic.turn.Turn;

import java.util.List;

public class TestCatERingKitchenTask5b {
	public static void main(String[] args) {
		System.out.println("TEST FAKE LOGIN");
		CatERing catERing = CatERing.getInstance();
		catERing.getUserManager().fakeLogin("Lidia");
		System.out.println(catERing.getUserManager().getCurrentUser());

		System.out.println("\nTABELLONE DEI TURNI");
		List<Turn> turnTable = catERing.getTurnManager().getTurnTable();
		System.out.println("######################################################");
		System.out.println(turnTable.toString().replace(", ", " "));
		System.out.println("######################################################");

		System.out.println("\nTEST SET TURN COMPLETENESS");
		int firstTurn = 0;
		Turn firstTurnInTheTable = catERing.getTurnManager().getTurnTable().get(firstTurn);
		boolean isComplete = true;
		System.out.println("Provo a segnare il primo turno nel tabellone come completato = "+ isComplete);
		catERing.getKitchenTaskManager().specifyTurnCompleteness(firstTurnInTheTable, isComplete);
		System.out.println("Tabellone post modifica: ");
		System.out.println("######################################################");
		turnTable = catERing.getTurnManager().getTurnTable(); //bisogna rifare la chiamata per ottenere l'aggiornamento fatto dal db
		System.out.println(turnTable.toString().replace(", ", " "));
		System.out.println("######################################################");

	}
}
