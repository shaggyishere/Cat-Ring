package test.kitchentask;

import businesslogic.CatERing;
import businesslogic.UseCaseLogicException;
import businesslogic.event.EventInfo;
import businesslogic.event.ServiceInfo;
import businesslogic.kitchentask.KitchenSheet;
import javafx.collections.ObservableList;

public class TestCatERingKitchenTask1a {
    public static void main(String[] args) {
        //Menu m = CatERing.getInstance().getMenuManager().createMenu("Menu Pinco Pallino");
        System.out.println("TEST FAKE LOGIN");
        CatERing.getInstance().getUserManager().fakeLogin("Lidia");
        System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());

        System.out.println("\nTEST GET EVENT BY NAME");
        EventInfo event = EventInfo.getEventByName("Compleanno di Manuela");
        System.out.println(event);

        System.out.println("\nTEST GET SERVICE BY EVENT ID");
        ObservableList<ServiceInfo> serviceInfos = ServiceInfo.loadServiceInfoForEvent(event.getId());
        System.out.println(serviceInfos);

        // TODO
//        try {
//            System.out.println("\nTEST CHOOSE SHEET");
//            KitchenSheet sheet = CatERing.getInstance().getKtMgr().chooseKitchenSheet("Primo foglio di prova", event, serviceInfos.stream().findFirst().get());
//            System.out.println(sheet);
//        } catch (UseCaseLogicException e) {
//            System.out.println("Errore di caso d'uso");
//        }
    }
}
