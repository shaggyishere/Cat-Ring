package businesslogic.kitchentask;

import businesslogic.CatERing;
import businesslogic.UseCaseLogicException;
import businesslogic.event.EventInfo;
import businesslogic.event.ServiceInfo;
import businesslogic.user.User;

import java.util.List;

public class KitchenTaskManager {
    private KitchenSheet currentSheet;
    private List<KitchenTaskEventReceiver> eventReceivers;

    public KitchenSheet createKitchenSheet(String title, EventInfo event, ServiceInfo service) throws UseCaseLogicException {
        User user = CatERing.getInstance().getUserManager().getCurrentUser();

        /*if (!user.isChef() ||
                !event.getServices().contains(service) ||
                !user.getAssignedEvents().contains(event) ||
                service.getUsedMenu() == null) {
            throw new UseCaseLogicException();
        }
*/
        KitchenSheet sheet = new KitchenSheet(title, service);

        setCurrentSheet(sheet);

        //notifySheetCreated(sheet);

        return sheet;
    }

    private void notifySheetCreated(KitchenSheet sheet) {
        for (KitchenTaskEventReceiver eventReceiver : eventReceivers) {
            eventReceiver.updateSheetCreated(sheet);
        }
    }

    public void setCurrentSheet(KitchenSheet currentSheet) {
        this.currentSheet = currentSheet;
    }
}
