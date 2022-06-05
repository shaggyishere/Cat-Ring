package test.kitchentask;

import businesslogic.CatERing;

public class TestCatERingKitchenTask5b {
    public static void main(String[] args) {
        System.out.println("TEST FAKE LOGIN");
        CatERing catERing = CatERing.getInstance();
        catERing.getUserManager().fakeLogin("Lidia");
        System.out.println(catERing.getUserManager().getCurrentUser());

        //TODO ottenere un turno qualsiasi da chiamata getTurnTable() (che fetcherà da db)

//        catERing.getKitchenTaskManager().specifyTurnCompleteness();
    }
}
